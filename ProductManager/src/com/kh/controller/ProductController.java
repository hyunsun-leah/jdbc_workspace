package com.kh.controller;

import java.util.ArrayList;

import com.kh.model.service.ProductService;
import com.kh.model.vo.Product;
import com.kh.view.ProductMenu;

public class ProductController {
	
	public void selectList() {
		ArrayList<Product> list = new ProductService().selectList();
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData("조회된 데이터가 없습니다.");
		}else {
			new ProductMenu().displayProductList(list);
		}
		
		
			
	}

	public void insertProduct(Product p) {
		
		int result = new ProductService().insertProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("상품추가 성공하였습니다.");
		}else {
			new ProductMenu().displayFail("상품추가 실패하였습니다.");
		}
		
	}

	public void updateProduct(Product p) {
		int result = new ProductService().updateProduct(p);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("성공적으로  변경되었습니다.");
		} else {
			new ProductMenu().displayFail("상품정보 변경에 실패하였습니다.");
		}
		
	}

	public void deleteProduct(String productId) {
		
		int result = new ProductService().deleteProduct(productId);
		
		if(result > 0) {
			new ProductMenu().displaySuccess("성공적으로 상품삭제되었습니다.");
		}else {
			new ProductMenu().displayFail("상품삭제에 실패하였습니다.");
		}
		
	}

	public void selectByProductName(String keyword) {
		ArrayList<Product> list = new ProductService().selectByProductName(keyword);
		
		if(list.isEmpty()) {
			new ProductMenu().displayNoData(keyword + "에 해당되는 조회 결과가 없습니다.");
		}else {
			new ProductMenu().displayProductList(list);
		}
		
	}

}
