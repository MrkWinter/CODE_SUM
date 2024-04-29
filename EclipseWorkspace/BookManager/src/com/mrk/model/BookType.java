package com.mrk.model;

/**
 * 实体类BookTpye
 * 
 * @author MrkWinter
 *
 */
public class BookType {
	public BookType() {
		super();
	}

	private Integer id; // 类别id
	private String typeName; // 类别名
	private String remark; // 类别描述

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public BookType(String typeName, String remark) {
		super();
		this.typeName = typeName;
		this.remark = remark;
	}

	@Override
	public String toString() {
		return this.typeName;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BookType) {
			return this.typeName.equals(((BookType)obj).getTypeName());
		} else {
			return super.equals(obj);
		}
	}
}
