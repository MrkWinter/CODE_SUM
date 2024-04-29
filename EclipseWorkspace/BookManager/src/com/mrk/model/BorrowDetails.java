package com.mrk.model;
/**
 * ʵ����BorrowDetails
 * @author MrkWinter
 *
 */
public class BorrowDetails {
	public BorrowDetails() {
		super();
	}

	private Integer id; //����id
	private Integer userId; //�û�id
	private Integer bookId; //ͼ��id
	private Integer status; // ����״̬ 0�ڽ��� 1�ѹ黹
	private Long borrowTime; //����ʱ��
	private Long returnTime; //�黹ʱ��

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getBorrowTime() {
		return borrowTime;
	}

	public void setBorrowTime(Long borrowTime) {
		this.borrowTime = borrowTime;
	}

	public Long getReturnTime() {
		return returnTime;
	}

	public void setReturnTime(Long returnTime) {
		this.returnTime = returnTime;
	}

	public BorrowDetails(Integer userId, Integer bookId, Integer status, Long borrowTime, Long returnTime) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.status = status;
		this.borrowTime = borrowTime;
		this.returnTime = returnTime;
	}

}
