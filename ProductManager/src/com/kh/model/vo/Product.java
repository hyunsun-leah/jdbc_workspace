package com.kh.model.vo;

public class Product {
	
	private String pId;
	private String pName;
	private int price;
	private String description;
	private int stock;
	
	public Product() {}

	public Product(String pId, String pName, int price, String description, int stock) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.price = price;
		this.description = description;
		this.stock = stock;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", price=" + price + ", description=" + description
				+ ", stock=" + stock + "]";
	}
	
	

}
