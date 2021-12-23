package com.example.domain;

/**
 * 注文商品用のドメイン
 * @author yukimatsunaga
 *
 */
public class OrderItem {
	// id
	private Integer id;
	// アイテムid
	private Integer itemId;
	// オーダーid
	private Integer orderId;
	// 商品
	private Item item;
	//金額
	private Integer price;
	

	

		

	
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	// getter/setterを定義
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", itemId=" + itemId + ", orderId=" + orderId + ", item=" + item + ", price="
				+ price + "]";
	}

}
