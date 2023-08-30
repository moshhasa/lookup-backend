package com.lookup.lookup.quote;

import com.lookup.lookup.BaseCrudController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentResource extends BaseCrudController<Comment> {

    @Override
    public void init() {
    }

    @GetMapping(path = "/{quoteId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comment> getComments(@PathVariable("quoteId") long quoteId) {
        return DummyQuote.getComments(quoteId);
    }

    @PostMapping(value = "/{quoteId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Comment addQuote(@PathVariable("quoteId") long quoteId, @RequestBody Comment comment) {
        return DummyQuote.addToQuote(quoteId, comment);
    }
}
