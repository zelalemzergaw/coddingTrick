package com.practice.onlinemarket.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.practice.onlinemarket.model.Product;
import com.practice.onlinemarket.service.ProductService;
import com.practice.onlinemarket.util.Utility;
import jdk.jshell.execution.Util;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@ExtendWith({SpringExtension.class})
@WebMvcTest(ProductController.class)
class ProductControllerTest {
    ProductController productController = new ProductController();
    Utility utility = new Utility();
    @Autowired
    private MockMvc mvc;
    @MockBean
    private ProductService productService;

    @Test
    public void mapToInitialPage() {

        String response = productController.mapToInitialPage();
        assertEquals("Welcome to first Page", "Welcome to first Page");
    }

    @Test
    void getAllProduct() throws Exception {
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

        String URI= "/product/findAll";

        Mockito.when(productService.findAll()).thenReturn((productList));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result =mvc.perform(requestBuilder).andReturn();
        String inputJson = utility.mapToJson(productList);
        String expectedJSON= result.getResponse().getContentAsString();
                assertThat(expectedJSON).isEqualTo(inputJson);

    }

    @Test
    void saveProduct() throws Exception {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

        String inputJSON= utility.mapToJson(product);
        String URI= "/product/save";
        Mockito.when(productService.save(Mockito.any(Product.class))).thenReturn(product);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJSON)
        .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputJSON= response.getContentAsString();
       assertThat(outputJSON).isEqualTo(inputJSON);
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    @Test
    void saveAllProduct() throws Exception {
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
        String inputJSON= utility.mapToJson(productList);
        String URI= "/product/saveAll";

        Mockito.when(productService.saveAllProducts(Mockito.anyList())).thenReturn((productList));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputJSON= response.getContentAsString();
        assertThat(outputJSON).isEqualTo(inputJSON);
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }

    @Test
    void getProductById() throws Exception {
        Product product=new Product();

        product.setId(1);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

        Mockito.when(productService.getProduct(Mockito.anyLong())).thenReturn(product);
        String URI= "/product/findById/1";
        RequestBuilder requestBuilder=MockMvcRequestBuilders.get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result= mvc.perform(requestBuilder).andReturn();
        String inputJson=utility.mapToJson(product);
        String expectedJSON= result.getResponse().getContentAsString();
        assertThat(expectedJSON).isEqualTo(inputJson);
    }

    @Test
    void getProductByName() throws Exception{
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
        String URI= "/product/findByName/Iphone";
        Mockito.when(productService.findByName(Mockito.anyString())).thenReturn((productList));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result =mvc.perform(requestBuilder).andReturn();
        String inputJson = utility.mapToJson(productList);
        String expectedJSON= result.getResponse().getContentAsString();
        assertThat(expectedJSON).isEqualTo(inputJson);
    }

    @Test
    void getProductByPrice() throws Exception {
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
        String URI= "/product/findByPrice/1300";
        Mockito.when(productService.findByPrice(Mockito.anyFloat())).thenReturn((productList));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result =mvc.perform(requestBuilder).andReturn();
        String inputJson = utility.mapToJson(productList);
        String expectedJSON= result.getResponse().getContentAsString();
        assertThat(expectedJSON).isEqualTo(inputJson);
    }

    @Test
    void deleteProduct() throws Exception {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);
        String input="The above Product is removed Sucessfully with id : 10";
        String uri = "/product/delete/10";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, input);
    }

    @Test
    void updateProduct() throws Exception {
        Product product=new Product();

        product.setId(10);
        product.setName("Iphone");
        product.setPrice(1200);
        product.setMadeIn("USA");
        product.setBrand("Iphone");
        product.setManufacturedDate(new SimpleDateFormat("dd/MM/yyyy").parse("11/14/2021"));
        product.setCustomer(null);

        String inputJSON= utility.mapToJson(product);
        String URI= "/product/update";
        Mockito.when(productService.updateProduct(Mockito.any(Product.class))).thenReturn(product);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URI)
                .accept(MediaType.APPLICATION_JSON).content(inputJSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult mvcResult = mvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = mvcResult.getResponse();
        String outputJSON= response.getContentAsString();
        assertThat(outputJSON).isEqualTo(inputJSON);
        assertEquals(HttpStatus.OK.value(),response.getStatus());
    }
}