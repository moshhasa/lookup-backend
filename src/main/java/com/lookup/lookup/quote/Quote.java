package com.lookup.lookup.quote;

import com.lookup.lookup.BaseResponse;

import java.util.ArrayList;
import java.util.List;

public class Quote extends BaseResponse<Quote> {

    private String author;
    private String text;
    private final List<Comment> comments = new ArrayList<>();

    public Quote() {}

    public Quote(long id, String author,  String text) {
        setId(id);
        this.author = author;
        this.text = text;

    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addToComment(Comment comment)
    {
        comments.add(comment);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
