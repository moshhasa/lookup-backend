package com.lookup.lookup.products;

import com.lookup.lookup.BaseCrudController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource extends BaseCrudController<Product> {

    @Override
    public void init() {
        setItems(Arrays.asList(new Product(1, "Book 1", 20.99, "My first product"),
                new Product(2, "Book 2", 16.50, "My second product"),
                new Product(3, "Book 3", 9.99, "My third product")));
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> getProducts() {
        return getItems();
    }

    @GetMapping(path = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduct(@PathVariable("ProductId") long productId) {
        return getItem(productId);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product addProduct(@RequestBody Product product) {
        return addItem(product);
    }

    @DeleteMapping("/{productId}")
    public List<Product> deleteProduct(@PathVariable("productId") int productId) {
        return deleteItem(productId);
    }

    @PutMapping(value = "/{productId}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Product updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
        return merge(productId, product);
    }

}
