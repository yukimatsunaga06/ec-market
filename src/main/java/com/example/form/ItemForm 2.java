package com.example.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

public class ItemForm {

	//	商品名
	@NotBlank(message="商品名を入力して下さい")
	private String name;
	
	//	商品説明
	@NotBlank(message="商品説明を入力して下さい")
	private String description;
	
	//価格
	@Pattern(regexp = "^[0-9]+$", message="価格は1以上の数字で入力して下さい")
	private String price;
	
	//	商品画像
	private MultipartFile imagePath;
	
	//カテゴリー
	@NotBlank(message="カテゴリーを入力して下さい")
	private String category;
	
	//	引数あり
	public ItemForm(String name, String description, String price, MultipartFile imagePath,
			String category) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.imagePath = imagePath;
		this.category = category;
	}
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public ItemForm() {
	}
	
	public int getIntPrice() {
		return Integer.parseInt(price);
	}

	//	GetterSetter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public MultipartFile getImagePath() {
		return imagePath;
	}
	public void setImagePath(MultipartFile imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "ItemForm [name=" + name + ", description=" + description + ", price=" + price + ", imagePath="
				+ imagePath + ", category=" + category + "]";
	}
	

}
