package se.jensenyh.javacourse.saltmerch.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;
import se.jensenyh.javacourse.saltmerch.backend.service.ProductService;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3010,")
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired

    ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();

    }

    @GetMapping("/products/hats")
    public List<Product> getAllHats() {
        return productService.getProductItems("hats");
    }

    @GetMapping("/products/tshirts")
    public List<Product> getAllTishirts() {
        return productService.getProductItems("tshirts");
    }

    @GetMapping("/products/bags")
    public List<Product> getAllBags() {
        return productService.getProductItems("bags");
    }

    @GetMapping("/products/jackets")
    public List<Product> getAllJackets() {
        return productService.getProductItems("jackets");
    }


    @GetMapping("/products/{id}")
    public Product getFromProductId(@PathVariable("id") int id) {
        return productService.getProductId(id);
    }


}
