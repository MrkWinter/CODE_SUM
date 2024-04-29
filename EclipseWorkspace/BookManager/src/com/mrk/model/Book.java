package com.mrk.model;
/**
 * 实体类book
 * @author MrkWinter
 *
 */
public class Book {
	private Integer id; // 书籍id
	private String bookName; // 书籍名
	private Integer typeId; //书籍类型
	private String author; //作者
	private String publish; //出版社
	private Double price; //价格
	private Integer number; //数字
	private Integer status; //状态 0未借阅 1已借阅
	private String remark; // 图书描述

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Book(String bookName, Integer typeId, String author, String publish, Double price, Integer number,
			Integer status, String remark) {
		super();
		this.bookName = bookName;
		this.typeId = typeId;
		this.author = author;
		this.publish = publish;
		this.price = price;
		this.number = number;
		this.status = status;
		this.remark = remark;
	}

	public Book() {
		super();
	}

}
