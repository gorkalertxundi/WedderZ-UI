package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.DataService;
import edu.wedderz.core.dataaccess.repo.serv.DataTypeService;
import edu.wedderz.core.model.Data;
import edu.wedderz.core.model.DataType;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.Station;

public class DataServiceImpl implements DataService {

	private DataTypeService dataTypeService = new DataTypeServiceImpl();

	@Override
	public Map<Date, Set<Data>> getProcessedDataLatest(Locality locality, int days) {
		Map<Date, Set<Data>> data = new TreeMap<>();

		if (days <= 0)
			return data;
		String query = "SELECT locality_id, data_type_id, data_date, data_value\r\n"
				+ "	FROM wedderz.processed_data\r\n" + "	WHERE locality_id = ?\r\n"
				+ "	AND data_date BETWEEN ? AND NOW()" + " ORDER BY data_date DESC;";

		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setInt(i++, locality.getLocalityId());
			statement.setDate(i++, Date.valueOf(LocalDate.now().minusDays(days)));
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Set<DataType> types = new HashSet<>();
			while (rs.next()) {
				DataType dataType = null;
				int dataTypeId = rs.getInt("data_type_id");
				Iterator<DataType> it = types.iterator();
				while (it.hasNext()) {
					DataType dt = it.next();
					if (dt.getDataTypeId() == dataTypeId)
						dataType = dt;
				}
				if (dataType == null) {
					dataType = dataTypeService.getDataTypeById(dataTypeId);
					types.add(dataType);
				}
				Date date = rs.getDate("data_date");
				double value = rs.getDouble("data_value");
				Set<Data> set;
				if (!data.containsKey(date)) {
					set = new HashSet<>();
					data.put(date, set);
				} else
					set = data.get(date);
				set.add(new Data(locality, dataType, date, value));
			}
			;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public Set<Data> getCrudeDataLatestByStation(Station station, int ammount) {
		Set<Data> dataSet = new TreeSet<>(Data.getComparator());
		if (ammount <= 0)
			return dataSet;

		String query = "SELECT data_time, data_type_id, data_value\r\n"
				+ "	FROM wedderz.crude_data where station_id = ?"
				+ " ORDER BY data_time DESC LIMIT ?;";

		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setInt(i++, station.getStationId());
			statement.setInt(i++, ammount);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Set<DataType> types = new HashSet<>();
			while (rs.next()) {
				DataType dataType = null;
				int dataTypeId = rs.getInt("data_type_id");
				Iterator<DataType> it = types.iterator();
				while (it.hasNext()) {
					DataType dt = it.next();
					if (dt.getDataTypeId() == dataTypeId)
						dataType = dt;
				}
				if (dataType == null) {
					dataType = dataTypeService.getDataTypeById(dataTypeId);
					types.add(dataType);
				}
				Date date = new Date(rs.getTimestamp("data_time").getTime());
				double value = rs.getDouble("data_value");
				dataSet.add(new Data(station.getLocality(), dataType, date, value));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dataSet;
	}

}
