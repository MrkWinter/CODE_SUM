package com.hkd.entity;

public class Cart {
	String itemid;
	String productid;
	String attr1;
	String name;
	int qty;
	int buyqty;
	double listprice;
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getAttr1() {
		return attr1;
	}
	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getBuyqty() {
		return buyqty;
	}
	public void setBuyqty(int buyqty) {
		this.buyqty = buyqty;
	}
	public double getListprice() {
		return listprice;
	}
	public void setListprice(double listprice) {
		this.listprice = listprice;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(String itemid, String productid, String attr1, String name, int qty, int buyqty, double listprice) {
		super();
		this.itemid = itemid;
		this.productid = productid;
		this.attr1 = attr1;
		this.name = name;
		this.qty = qty;
		this.buyqty = buyqty;
		this.listprice = listprice;
	}
	@Override
	public String toString() {
		return "Cart [itemid=" + itemid + ", productid=" + productid + ", attr1=" + attr1 + ", name=" + name + ", qty="
				+ qty + ", buyqty=" + buyqty + ", listprice=" + listprice + "]";
	}
	
	
	

}
