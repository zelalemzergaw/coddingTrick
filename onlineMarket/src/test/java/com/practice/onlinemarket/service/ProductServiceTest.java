package com.practice.onlinemarket.service;

import com.practice.onlinemarket.controller.ProductController;
import com.practice.onlinemarket.model.Product;
import com.practice.onlinemarket.ropository.ProductRepository;
import com.practice.onlinemarket.util.MyUtility;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@ExtendWith({SpringExtension.class})
@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceTest {
    ProductController productController = new ProductController();
    MyUtility utility = new MyUtility();

    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;

    @Test
    void findAll() throws ParseException {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

        Product product2=new Product();
        product2.setId(20);
        product2.setName("PhoneG");
        product2.setPrice(1300);
        product2.setMadeIn("Germany");
        product2.setBrand("GG");
        product2.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/13/2020"));
        product2.setCustomer(null);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        productList.add(product2);
        Mockito.when(productRepository.findAll()).thenReturn(productList);
        assertThat(productService.findAll()).isEqualTo(productList);
    }

    @Test
    void findById() throws ParseException {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

        Mockito.when(productRepository.findById(10L)).thenReturn(Optional.of(product));
        assertThat(productService.findById(10L)).isEqualTo(product);
    }

    @Test
    void findByName() throws ParseException {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);
        List<Product> productList =new ArrayList<>();
        productList.add(product);
        Mockito.when(productRepository.findByName("Iphone")).thenReturn(productList);
        assertThat(productService.findByName("Iphone")).isEqualTo(productList);
    }

    @Test
    void findByPrice() throws ParseException {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);
        List<Product> productList =new ArrayList<>();
        productList.add(product);
        Mockito.when(productRepository.findByPrice(1200)).thenReturn(productList);
        assertThat(productService.findByPrice(1200)).isEqualTo(productList);
    }

    @Test
    void save() throws ParseException {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

        Mockito.when(productRepository.save(product)).thenReturn(product);
        assertThat(productService.save(product)).isEqualTo(product);
    }

    @Test
    void saveAllProducts() throws ParseException {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

        Product product2=new Product();
        product2.setId(20);
        product2.setName("PhoneG");
        product2.setPrice(1300);
        product2.setMadeIn("Germany");
        product2.setBrand("GG");
        product2.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("1/13/2020"));
        product2.setCustomer(null);

        List<Product> productList = new ArrayList<Product>();
        productList.add(product);
        productList.add(product2);
        Mockito.when(productRepository.saveAll(productList)).thenReturn(productList);
        assertThat(productService.saveAllProducts(productList)).isEqualTo(productList);
    }

    @Test
    void getProduct() throws ParseException {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

        Mockito.when(productRepository.findById(10L)).thenReturn(Optional.of(product));
        assertThat(productService.getProduct(10L)).isEqualTo(product);
    }
    @Ignore
    @Test
    void deleteById() throws ParseException {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

    }

    @Test
    void updateProduct() {
    }

    @Test
    void computeVal() {
    }
}