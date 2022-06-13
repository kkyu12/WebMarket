package com.kkyu.domain.model;

import java.util.Objects;

// 1. 무지성 private 멤버 변수
// 2. 필요하면 생성자 추가
// 3. 무지성 getter / setter 읽기 전용, 쓰기 전용
// 4. 무지성 toString()
// 5. 필요하면 equals / hashCode 재정의 (오버라이드)
public class Product { // f4 누르면 상속도 관계가 나옴 extends Object 생략된 것
  public static void main(String[] args) {
    Product product = new Product("33","33",11);
    product.id = "33";
    // product.setId("111");
    System.out.println(product.hashCode());

    Product product2 = new Product("33","33",11);
    System.out.println(product2.hashCode());

    Object object = new Product("33","33",11);

    // System.out.println(product == product2); 
    // == : 주소비교(레퍼런스비교) hasCode가 다름  // 결과 false // new할 때 마다 다 다른 것
    
    // 근데 id가 같으면 같은 걸로 처리해야된다
    System.out.println(product.equals(product2)); // 결과 false 소스 추가후 true
    System.out.println(product.hashCode() == product2.hashCode()); // hashCode가 재정의 됨 결과 true 소스 추가 될때 hashCode가 추가된 이유 알아서 맞춰주려고
    System.out.println(product == product2); // 주소는 모르지만 다른 것 false
  }
  // crtl + O 메소드
  // static 다른 공간에 메모리가 있는 // 메소드도 변수도 static 붙는 순간 다른 공간에 저장 // 동적은 new // 정적과 동적은 다른 동네에 있음
  private String id;
  private String name;
  private int unitPrice;
  private String description;
  private String manufacturer;
  private String category;
  private long unitsInStock;
  private String condition;

	public Product(String id, String name, int unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

  // 캡슐화
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", description=" + description
				+ ", manufacturer=" + manufacturer + ", category=" + category + ", unitsInStock=" + unitsInStock
				+ ", condition=" + condition + "]";
	}
}