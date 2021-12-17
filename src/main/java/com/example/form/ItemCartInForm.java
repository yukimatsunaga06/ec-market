package com.example.form;

/**
 * @author yukimatsunaga
 * 
 * ショッピングカートに商品追加するためのフォームクラス
 *
 */
public class ItemCartInForm {

	//商品名
	private String name;
	
	//値段
	private Integer price;
	//商品id
	private Integer id;
	//image
	private String imagePath;
	
	
	
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "ItemCartInForm [name=" + name + ", price=" + price + ", id=" + id + ", imagePath=" + imagePath + "]";
	}
	
}
