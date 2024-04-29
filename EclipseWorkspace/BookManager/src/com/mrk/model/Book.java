package com.mrk.model;
/**
 * ʵ����book
 * @author MrkWinter
 *
 */
public class Book {
	private Integer id; // �鼮id
	private String bookName; // �鼮��
	private Integer typeId; //�鼮����
	private String author; //����
	private String publish; //������
	private Double price; //�۸�
	private Integer number; //����
	private Integer status; //״̬ 0δ���� 1�ѽ���
	private String remark; // ͼ������

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
