package com.example.tranvanduong.seeder;

import com.example.tranvanduong.entity.Product;
import com.example.tranvanduong.repository.ProductRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ProductSeeder implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;


    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker();
        List<Product> products = new ArrayList<>();

        for (int i = 0; i < 50; i++){
            Product product = new Product();
            product.setId(UUID.randomUUID().toString());
            product.setName(faker.food().vegetable());
            product.setQuantity(faker.number().numberBetween(10, 50));
            product.setPrice(new BigDecimal(faker.number().numberBetween(10, 200) * 1000));
            products.add(product);
        }
        productRepository.saveAll(products);
    }
}
