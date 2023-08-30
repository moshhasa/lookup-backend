package com.lookup.lookup.quote;

import com.lookup.lookup.BaseCrudController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quotes")
public class QuoteResource extends BaseCrudController<Quote> {

    @Override
    public void init() {
        setItems(DummyQuote.QUOTES);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Quote> getQuotes() {
        return getItems();
    }

    @GetMapping(path = "/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Quote getQuote(@PathVariable("quoteId") long quoteId) {
        return getItem(quoteId);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Quote addQuote(@RequestBody Quote quote) {
        return addItem(quote);
    }

    @DeleteMapping("/{quoteId}")
    public List<Quote> deleteQuote(@PathVariable("quoteId") int quoteId) {
        return deleteItem(quoteId);
    }

    @PutMapping(value = "/{quoteId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Quote updateQuote(@PathVariable("quoteId") int quoteId, @RequestBody Quote quote) {
        return merge(quoteId, quote);
    }

}
