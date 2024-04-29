package com.mrk.entity;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Inventory {
    private String itemId; // 项目编号
    private int qty; // 库存量

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}

