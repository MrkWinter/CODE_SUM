package com.mrk.entity;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Product {
    private String productId; // 图书编号
    private String category; // 分类编号
    private String name; // 图书名称
    private String descn; // 图书描述

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescn() {
        return descn;
    }

    public void setDescn(String descn) {
        this.descn = descn;
    }
}

