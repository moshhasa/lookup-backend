package com.lookup.lookup.quote;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DummyQuote {
    public static List<Quote> QUOTES = new ArrayList<>();

    static {
//        QUOTES.addAll(Arrays.asList(new Quote(1, "James Jones", "My first quote"),
//                new Quote(2, "Philipa Baafi", "My second quote"),
//                new Quote(3, "Reema Conteh", "My third quote")));
    }

    public static List<Comment> getComments(long quoteId) {
        Quote quote = QUOTES.stream().filter(q -> q.getId() == quoteId).findFirst().orElse(null);
        return quote == null ? Collections.EMPTY_LIST : quote.getComments();
    }

    public static Comment addToQuote(long quoteId, Comment comment) {
        QUOTES.stream()
                .filter(q -> q.getId() == quoteId).findFirst()
                .ifPresent(q -> {
                    comment.setId(System.currentTimeMillis());
                    q.addToComment(comment);
                });
        return comment;
    }

    public static void addQuote(Quote quote) {
        QUOTES.add(quote);
    }
}
