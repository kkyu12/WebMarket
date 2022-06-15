<%@page import="com.kkyu.domain.repository.ProductRepository"%>
<%@page import="com.kkyu.domain.model.Product"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 한글 잘 나오게 인코딩
request.setCharacterEncoding("UTF-8");

// POST로 넘어 온 것
String productId = request.getParameter("productId");
String name = request.getParameter("name");
int unitPrice = Integer.valueOf(request.getParameter("unitPrice"));
String description = request.getParameter("description");
String manufacturer = request.getParameter("manufacturer");
String category = request.getParameter("category");
int unitsInStock = Integer.valueOf(request.getParameter("unitsInStock"));
String condition = request.getParameter("condition");

// 유효성 체크 (생략)

// 상품 추가
ProductRepository repository = ProductRepository.getInstance();

Product product = new Product(productId, name, unitPrice);
product.setDescription(description);
product.setManufacturer(manufacturer);
product.setCategory(category);
product.setUnitsInStock(unitsInStock);
product.setCondition(condition);

repository.addProduct(product);

// 추가 후 상품목록 페이지로 이동
response.sendRedirect("products.jsp");
%>