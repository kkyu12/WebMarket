package com.kkyu.data;

import java.util.List;
import com.kkyu.data.dao.ProductDao;
import com.kkyu.domain.model.Product;
import com.kkyu.domain.repository.ProductRepository;

public class ProductRepositoryDbImpl implements ProductRepository {
	private ProductDao dao;
	
	public ProductRepositoryDbImpl(ProductDao dao) {
		this.dao = dao;
	}
	
	// 강제 오버라이드
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	@Override
	public Product getProductById(String id) {
	    return getAllProducts().stream()
	  	      .filter((product) -> product.getId().equals(id)) // 조건
	  	      .findFirst() // 첫번째
	  	      .get(); // 얻기
	}

	@Override
	public void addProduct(Product product) {
		dao.insert(product);
	}

}
