package com.lookup.lookup.meal;


import com.lookup.lookup.BaseResponse;

import java.util.List;

public class Checkout extends BaseResponse<Checkout> {

    private User user;
    private List<Order> orderedItems;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(List<Order> orderedItems) {
        this.orderedItems = orderedItems;
    }

}
