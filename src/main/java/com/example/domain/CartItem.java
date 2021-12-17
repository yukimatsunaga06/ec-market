package com.example.domain;

public class CartItem {
	
	//商品Id
	private Integer itemId;
	//商品名
	private String name;
	//商品画像
	private String imagePath;
	//商品の元々の金額
	private Integer price;
	
	
	
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getprice() {
		return price;
	}
	public void setprice(Integer price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
		
	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", name=" + name + ", imagePath=" + imagePath
				+ ", price=" + price + "]";
	}
	
}
