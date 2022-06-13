package com.kkyu.data;

import java.util.ArrayList;
import java.util.List;
import com.kkyu.domain.model.Product;

public class ProductRepository {

  private List<Product> products = new ArrayList<>();

  public ProductRepository() {
    Product phone = new Product("P1234", "iPhone 6s", 800000);
    phone.setDescription("4.7-inch, 1334x750 Retina HD display");
    phone.setCategory("Smart Phone");
    phone.setManufacturer("Apple");
    phone.setUnitsInStock(1000);
    phone.setCondition("New");

    Product notebook = new Product("P1235", "LG PC 그램", 1500000);
    notebook.setDescription("4.7-inch, 1334x750 Retina HD display");
    notebook.setCategory("!Smart Phone");
    notebook.setManufacturer("Apple");
    notebook.setUnitsInStock(1000);
    notebook.setCondition("Refubished");

    Product tablet = new Product("P1236", "Galaxy Tab S", 900000);
    tablet.setDescription("4.7-inch, 1334x750 Retina HD display");
    tablet.setCategory("?Smart Phone");
    tablet.setManufacturer("Apple");
    tablet.setUnitsInStock(1000);
    tablet.setCondition("Old");

    products.add(phone);
    products.add(notebook);
    products.add(tablet);
  }

  public List<Product> getAllProducts() {
    return products;
  }
  
  public Product getProductById(String id) {
    // List -> Stream (데이터의 흐름) p.173과 비교
    return products.stream()
      .filter((product) -> product.getId().equals(id))
      .findFirst()
      .get();
  }
}
