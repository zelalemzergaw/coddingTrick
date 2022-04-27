package com.practice.onlinemarket.controller;

import com.practice.onlinemarket.model.Product;
import com.practice.onlinemarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "product")
public class ProductController {
    @Autowired
    public ProductService productService;

    @GetMapping("/findAll" )
    public List<Product> getAllProduct(){
        return productService.findAll();
    }
    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product){
        productService.save(product);
    }
    @PostMapping("/saveAll")
    public void saveAllProduct(@RequestBody List<Product> products){
        productService.saveAllProducts(products);
    }
    @GetMapping("/findById/{id}")
    public Product getProductById(@PathVariable long id){
        return productService.getProduct(id);
    }
    @GetMapping("/findByName/{name}")
    public List<Product> getProductByName(@PathVariable String name){;
        return productService.findByName(name);
    }
    @GetMapping("/findByPrice/{price}")
    public List<Product> getProductByPrice(@PathVariable float price){;
        return productService.findByPrice(price);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){
        productService.deleteById(id);
        return "The above Product is removed Sucessfully with id : " + id;
    }
    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
       return productService.updateProduct(product);
    }
}
