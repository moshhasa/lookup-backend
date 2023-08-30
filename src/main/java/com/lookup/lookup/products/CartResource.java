package com.lookup.lookup.products;

import com.lookup.lookup.BaseCrudController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cart")
public class CartResource extends BaseCrudController<Cart> {

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart getCart() {
        return getItems().get(0);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Cart setCart(@RequestBody Cart cart) {
        setItems(cart);
        return cart;
    }



    @Override
    public void init() {

    }
}