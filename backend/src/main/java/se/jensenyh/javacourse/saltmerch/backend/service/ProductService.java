package se.jensenyh.javacourse.saltmerch.backend.service;

import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;
import java.util.List;
@Service
public class ProductService {
    @Autowired
    public ProductRepository productRepository;

    public List<Product> getAllProduct() {
        return  productRepository.selectAll(null);
    }

    public List<Product> getProductItems(String category) {
        return productRepository.selectAll(category);

    }
    public  Product getProductId(int productId){
        return productRepository.getEntireProduct( productId);

    }
}









