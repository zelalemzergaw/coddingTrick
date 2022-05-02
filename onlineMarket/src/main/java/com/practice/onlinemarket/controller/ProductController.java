package com.practice.onlinemarket.controller;

import com.practice.onlinemarket.model.Product;
import com.practice.onlinemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("")
    public String mapToInitialPage() {
        return "<h>Welcome to first Page<h>";
    }

    @GetMapping("/rev/{number}")
    public int reverseString(@PathVariable int number) {
        return productService.computeVal(number);
    }

    @GetMapping("/product/findAll")
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    @PostMapping("/product/save")
    public void saveProduct(@RequestBody Product product) {
        productService.save(product);
    }

    @PostMapping("/product/saveAll")
    public void saveAllProduct(@RequestBody List<Product> products) {
        productService.saveAllProducts(products);
    }

    @GetMapping("/product/findById/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProduct(id);
    }

    @GetMapping("/product/findByName/{name}")
    public List<Product> getProductByName(@PathVariable String name) {
        ;
        return productService.findByName(name);
    }

    @GetMapping("/product/findByPrice/{price}")
    public List<Product> getProductByPrice(@PathVariable float price) {
        ;
        return productService.findByPrice(price);
    }

    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteById(id);
        return "The above Product is removed Sucessfully with id : " + id;
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
