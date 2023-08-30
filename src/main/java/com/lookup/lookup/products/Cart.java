package com.lookup.lookup.products;

import com.lookup.lookup.BaseResponse;

import java.util.List;

public class Cart extends BaseResponse<Cart> {
    private List<CartItem> items;
    private double totalQuantity;
    private double totalAmount;

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(double totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
