package com.lookup.lookup.quote;

import com.lookup.lookup.BaseResponse;

public class Comment extends BaseResponse<Comment> {
    private String text;
    private String name;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
