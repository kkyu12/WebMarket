package com.kkyu.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.kkyu.domain.model.Product;

// MySQL 용
public class MySqlProductDaoImpl implements ProductDao {

	public MySqlProductDaoImpl() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("jdbc 드라이버 로드 실패");
		}
	}
	
	@Override
	public List<Product> getAll() {
		List<Product> results = new ArrayList<>();
		String sql = "SELECT * FROM product";
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kopo27", "root", "kopo27"); 
				Statement stmt = conn.createStatement();) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					String id = rs.getString("p_id");
					String name = rs.getString("p_name");
					int unitPrice = rs.getInt("p_unitPrice");
					String description = rs.getString("p_description");
					String category = rs.getString("p_category");
					String manufacturer = rs.getString("p_manufacturer");
					long unitsInStock = rs.getLong("p_unitsInStock");
					String condition = rs.getString("p_condition");
					
					Product product = new Product(id, name, unitPrice);
					product.setDescription(description);
					product.setCategory(category);
					product.setManufacturer(manufacturer);
					product.setUnitsInStock(unitsInStock);
					product.setCondition(condition);
					
					results.add(product);
				}
			}
		} catch (SQLException e) {
			// e.getMessage() 로 에러가 나면 에러 내용이 출력되도록
			throw new IllegalStateException("db 연결 실패" + e.getMessage());
		}
		return results;
	}

	@Override
	public void insert(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product product) {
		// TODO Auto-generated method stub
		
	}

}
