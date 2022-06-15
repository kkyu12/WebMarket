package com.kkyu.data.dao;

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
		// TODO Auto-generated method stub
		return null;
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
