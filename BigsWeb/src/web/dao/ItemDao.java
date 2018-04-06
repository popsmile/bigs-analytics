package web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import web.dto.ItemDto;


public class ItemDao {

	DataSource dataSource;
	
	public ItemDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("jdbc:mysql://localhost/bigs_test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ItemDto> list() {
		
		ArrayList<ItemDto> dtos = new ArrayList<ItemDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select item_no, item_name, item_desc, item_desc2 from items order by item_no asc";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int itemNo = resultSet.getInt("item_no");
				String itemName = resultSet.getString("item_name");
				String itemDesc = resultSet.getString("item_desc");
				String itemDesc2 = resultSet.getString("item_desc2");
				
				ItemDto dto = new ItemDto(itemNo, itemName, itemDesc, itemDesc2);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return dtos;
	}
	
	
	
}
