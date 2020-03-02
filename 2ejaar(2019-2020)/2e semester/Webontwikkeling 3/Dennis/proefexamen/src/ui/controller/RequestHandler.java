package ui.controller;

import domain.model.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public abstract class RequestHandler {
	
	private ProductService productService;
	
	public abstract void handleRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
	public void setModel (ProductService bookService) {
		this.productService = bookService;
	}

	public ProductService getProductService() {
		return productService;
	}
	
	
}
