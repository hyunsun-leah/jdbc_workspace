package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.ProductController;
import com.kh.model.vo.Product;

public class ProductMenu {
	
	private Scanner sc = new Scanner(System.in);
	
	private ProductController pc = new ProductController();
	
	public void mainMenu() {
		
		int menu;
		while(true) {
			System.out.println("\n==== 제품 관리 프로그램 ====");
			System.out.println("1. 전체 조회 하기");
			System.out.println("2. 상품 추가 하기");
			System.out.println("3. 상품 수정 하기(상품id입력)"); // 상품id로 조회하고 수정
			System.out.println("4. 상품 삭제 하기(상품id입력)"); // 상품id로 조회하고 삭제
			System.out.println("5. 상품 검색하기"); // 상품 이름으로 키워드 검색
			System.out.println("0. 프로그램 종료하기");
			System.out.print("메뉴 선택 : ");
			menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1: pc.selectList(); break;
			case 2: insertProduct(); break;
			case 3: updateProduct(); break;
			case 4: pc.deleteProduct(inputProductId()); break;
			case 5: pc.selectByProductName(inputProductName()); break;
			case 0: System.out.print("정말로 끝내겠습니까? (y/n) : ");
					if(sc.nextLine().toUpperCase().charAt(0) == 'Y') {
						System.out.println("프로그램을 종료합니다.");
						return;
					}else {
						break;
					}
				default:System.out.println("번호를 잘못 입력했습니다. 다시 입력해주세요.");
			}
			
		}
		
	}


	// 상품추가하는 화면
	private void insertProduct() {
		System.out.println("\n=== 상품 추가 ===");
		System.out.print("상품 아이디: ");
		String pId = sc.nextLine();
		System.out.print("상품명: ");
		String pName = sc.nextLine();
		System.out.print("상품가격: ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("상품상세정보: ");
		String description = sc.nextLine();
		System.out.print("재고: ");
		int stock = sc.nextInt();
		
		pc.insertProduct(new Product(pId, pName, price, description, stock));
		
	}

	// 상품수정하는 화면
	private void updateProduct() {
		
		System.out.println("\n=== 상품 수정 ===");
		
		Product p = new Product();
		p.setpId(inputProductId());
		
		System.out.print("변경할 상품이름: ");
		p.setpName(sc.nextLine());
		System.out.print("변경할 가격: ");
		p.setPrice(sc.nextInt());
		sc.nextLine();
		System.out.print("변경할 상품상세정보: ");
		p.setDescription(sc.nextLine());
		System.out.print("변경할 재고수량: ");
		p.setStock(sc.nextInt());
		
		pc.updateProduct(p);
		
	}

	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}


	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
		
	}


	private String inputProductId() {
		System.out.print("\n상품 id 입력 : ");
		return sc.nextLine();
	}




	public void displayNoData(String message) {
		System.out.println("\n" + message);
	}


	public void displayProductList(ArrayList<Product> list) {
		System.out.println("\n조회된 상품정보는 다음과 같습니다.");
		for(Product p : list) {
			System.out.println(p);
		}
	}
	
	private String inputProductName() {
		System.out.print("\n검색할 상품명(키워드) 입력 : ");
		return sc.nextLine();
	}

}
