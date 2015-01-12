package com.householdreminder.model;

public class Item {

	private int ItemId;
	private String ItemName;
	private Boolean IsBought;
	private int Quantity;
	
	public int getItemId() {
		return ItemId;
	}
	public void setItemId(int itemId) {
		ItemId = itemId;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Boolean getIsBought() {
		return IsBought;
	}
	public void setIsBought(Boolean isBought) {
		IsBought = isBought;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
}
