package com.example.domain;

/**
 * アイテムを表すドメインクラスです.<br>
 * 
 * @author cyjoh
 *
 */
public class Item {
	/** ID */
	private Integer id;

	/** アイテム名 */
	private String name;

	/** 説明 */
	private String description;

	/** 価格 */
	private Integer price;

	/** 画像パス */
	private String imagePath;

	/** 削除フラグ */
	private boolean deleted;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imagePath=" + imagePath + ", deleted=" + deleted + "]";
	}

	
	
}