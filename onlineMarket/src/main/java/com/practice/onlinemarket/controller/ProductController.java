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

    /**
     * welcome page
     * @return
     */
    @GetMapping("")
    public String mapToInitialPage() {
        return "Welcome to first Page";
    }

    @GetMapping("/rev/{number}")
    public int reverseString(@PathVariable int number) {
        return productService.computeVal(number);
    }

    /**
     * Find all products
     * @return
     */
    @GetMapping("/product/findAll")
    public List<Product> getAllProduct() {
        return productService.findAll();
    }

    /**
     * save one product
     * @param product
     * @return
     */
    @PostMapping("/product/save")
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    /**
     * Save all products
     * @param products
     * @return
     */
    @PostMapping("/product/saveAll")
    public List<Product> saveAllProduct(@RequestBody List<Product> products) {
        return productService.saveAllProducts(products);
    }

    /**
     * Find product with specific id
     * @param id
     * @return
     */
    @GetMapping("/product/findById/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProduct(id);
    }

    /**
     * Find all product by name
     * @param name
     * @return
     */
    @GetMapping("/product/findByName/{name}")
    public List<Product> getProductByName(@PathVariable String name) {

        return productService.findByName(name);
    }

    /**
     * Find price with specific/ given price from the user
     * @param price
     * @return
     */
    @GetMapping("/product/findByPrice/{price}")
    public List<Product> getProductByPrice(@PathVariable float price) {

        return productService.findByPrice(price);
    }

    /**
     * Delete product by id
     * @param id
     * @return
     */
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteById(id);
        return "The above Product is removed Successfully with id : " + id;
    }

    /**
     * Update product
     * @param product
     * @return
     */
    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }
}
