package com.mrk.entity;

/**
 * @author MrkWinter
 * @version 1.0
 */
import java.math.BigDecimal;

public class LineItem {
    private int orderId; // 订单编号
    private int lineNum; // 行号
    private String itemId; // 明细编号
    private int quantity; // 数量
    private BigDecimal unitPrice; // 价格

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
