package com.kkyu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kkyu.domain.model.Product;
import com.kkyu.domain.repository.ProductRepository;

@WebServlet(name = "ProductController", urlPatterns = {"/products.do", "/addProduct.do"})
public class ProductController extends HttpServlet {

	private static final long serialVersionUID = -8971822576178641934L;
	
	// doGet 쓰고 ctrl + space 하고 엔터
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 요청주소 (products.do)
		String command = req.getRequestURI().substring(req.getContextPath().length());
        // 싱글턴패턴
        ProductRepository repository = ProductRepository.getInstance();
		if (command.equals("/products.do")) {
			List<Product> products = repository.getAllProducts();
			req.getSession().setAttribute("products", products);
            
		} else if (command.equals("/addProduct.do")){
			
		}
		
		System.out.println("통과!!!!!!!!!!");
		
		// products.jsp 로 이동
		req.getRequestDispatcher("products.jsp").forward(req, resp);
	}
	
	// doPost 쓰고 ctrl + space 하고 엔터
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
