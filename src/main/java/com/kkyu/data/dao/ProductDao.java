package com.kkyu.data.dao;

import java.util.List;
import com.kkyu.domain.model.Product;

// Data Access Object
// DB 와 연결할 곳
public interface ProductDao {
	// interface 안에 작성한 멤버 = public final static 이 생략되어 있다 수정불가
	static String TABLE_NAME = "product";
	static String COLUMN_ID = "p_id";
	
	// interface 안에서는 public 생략되어 있고 public만 사용 가능
	// Product getID 하나씩 찾는 것도 만들면 좋음 (생략)
	List<Product> getAll();
	
	void insert(Product product);
	
	void update(Product product);
	
	void delete(Product product);
}
