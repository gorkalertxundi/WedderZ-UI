package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.DataTypeService;
import edu.wedderz.core.dataaccess.repo.serv.ProcessedDataService;
import edu.wedderz.core.model.DataType;
import edu.wedderz.core.model.Locality;
import edu.wedderz.core.model.ProcessedData;

public class ProcessedDataServiceImpl implements ProcessedDataService {
	
	private DataTypeService dataTypeService = new DataTypeServiceImpl();

	@Override
	public Map<Date, Set<ProcessedData>> getProcessedDataLatest(Locality locality, int days) {
		Map<Date, Set<ProcessedData>> data = new TreeMap<>();
		
		if(days <= 0) return data;
		String query = "SELECT locality_id, data_type_id, data_date, data_value\r\n"
				+ "	FROM wedderz.processed_data\r\n"
				+ "	WHERE locality_id = ?\r\n"
				+ "	AND data_date BETWEEN ? AND NOW()"
				+ " ORDER BY data_date DESC;";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			int i = 1;
			statement.setInt(i++, locality.getLocalityId());
			statement.setDate(i++, Date.valueOf(LocalDate.now().minusDays(days)));
			statement.execute();
			ResultSet rs = statement.getResultSet();
			Set<DataType> types = new HashSet<>();
			while(rs.next()) {
				DataType dataType = null;
				int dataTypeId = rs.getInt("data_type_id");
				Iterator<DataType> it = types.iterator();
				while(it.hasNext()){
					DataType dt = it.next();
					if(dt.getDataTypeId() == dataTypeId) dataType = dt;
				}
				if(dataType == null) {
					dataType = dataTypeService.getDataTypeById(dataTypeId);
					types.add(dataType);
				}
				Date date = rs.getDate("data_date");
				double value = rs.getDouble("data_value");
				Set<ProcessedData> set;
				if(!data.containsKey(date)) {
					set = new HashSet<>();
					data.put(date, set);
				}
				else set = data.get(date);
				set.add(new ProcessedData(locality, dataType, date, value));
			};
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
	}

	@Override
	public Map<Date, Set<ProcessedData>> getProcessedDataByDate(Locality locality, Date date, int days) {
		Map<Date, Set<ProcessedData>> data = new TreeMap<>();
		return data;
	}

	
	
}
