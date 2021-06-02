package edu.wedderz.core.dataaccess.repo.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.wedderz.core.dataaccess.PostgreSQLCon;
import edu.wedderz.core.dataaccess.repo.serv.DataTypeService;
import edu.wedderz.core.model.DataType;

public class DataTypeServiceImpl implements DataTypeService {

	@Override
	public DataType getDataTypeById(int dataTypeId) {
		String query = "SELECT data_type_id, description, unit FROM wedderz.data_type WHERE data_type_id = ?";
		
		try (Connection con = PostgreSQLCon.getConnection()) {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setInt(1, dataTypeId);
			statement.execute();
			ResultSet rs = statement.getResultSet();
			rs.next();
			
			String description = rs.getString("description");
			String unit = rs.getString("unit");
			return new DataType(dataTypeId,description, unit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
