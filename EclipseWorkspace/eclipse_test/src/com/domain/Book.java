package com.domain;

public class Book {
	private Integer id;
	private Integer bookNo;
	private String bookName;
	private String author;
	private String publisher;
	private Double price;
	private String publishTime;
	private Integer ISBN;
	private Integer amount;

	public Book(Integer bookNo, String bookName, String author, String publisher, Double price, String publishTime,
			Integer iSBN, Integer amount) {
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.publishTime = publishTime;
		this.ISBN = iSBN;
		this.amount = amount;
	}

	public Integer getBookNo() {
		return bookNo;
	}

	public void setBookNo(Integer bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public Integer getISBN() {
		return ISBN;
	}

	public void setISBN(Integer iSBN) {
		ISBN = iSBN;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookNo=" + bookNo + ", bookName=" + bookName + ", author=" + author
				+ ", publisher=" + publisher + ", price=" + price + ", publishTime=" + publishTime + ", ISBN=" + ISBN
				+ ", amount=" + amount + "]";
	}

}
