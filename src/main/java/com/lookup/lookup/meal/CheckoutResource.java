package com.lookup.lookup.meal;

import com.lookup.lookup.BaseCrudController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("checkout")
public class CheckoutResource extends BaseCrudController<Checkout> {

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Checkout checkout(@RequestBody Checkout checkout) {
        return addItem(checkout);
    }

    @Override
    public void init() {

    }

}
