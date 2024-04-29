package com.mrk.entity;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Category {
    private String catId; // 分类编号
    private String name; // 分类名称
    private String descn; // 描述

    public String getCatId() {
        return catId;
    }

    public void setCatId(String catId) {
        this.catId = catId;
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

