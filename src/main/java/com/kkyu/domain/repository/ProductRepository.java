package com.kkyu.domain.repository;

import java.util.List;
import com.kkyu.data.ProductRepositoryDbImpl;
import com.kkyu.data.ProductRepositoryImpl;
import com.kkyu.data.dao.MySqlProductDaoImpl;
import com.kkyu.domain.model.Product;

public interface ProductRepository {
	// 공통기능을 인터페이스에 저장
	public static ProductRepository getInstance() {
		// return ProductRepositoryImpl.getInstance(); // 메모리로 연결
		return new ProductRepositoryDbImpl(new MySqlProductDaoImpl()); // MySql로 연결
	}
	
	public List<Product> getAllProducts();
	
	public Product getProductById(String id);
	
	public void addProduct(Product product);
}
