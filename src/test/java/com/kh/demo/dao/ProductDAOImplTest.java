package com.kh.demo.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class ProductDAOImplTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    @DisplayName("상품 등록")
    void save() {
        Product product = new Product();
        product.setProductId(1l);
        product.setPname("사과");
        product.setPrice(3000l);
        product.setQuantity(10l);


        productDAO.save(product);

    }

    @Test
    @DisplayName("상품 목록")
    void findAll() {
        List<Product> products = productDAO.findAll();
        products.stream().forEach(product -> {
            log.info("products={}",products);
        });
    }

    @Test
    @DisplayName("상품 조회")
    void findByProductId() {

        Optional<Product> foundProduct = productDAO.findByProductId(1l);
        Product product = foundProduct.get();
        log.info("product={}",product);
    }



    @Test
    @DisplayName("상품 수정")
    void update() {

        Optional<Product> foundProduct = productDAO.findByProductId(1l);
        Product product = foundProduct.get();
        product.setPname("사과_수정");
        product.setPrice(4000l);
        product.setQuantity(5l);


        productDAO.update(1l,product);
        log.info("product={}",product);
    }

    @Test
    @DisplayName("상품 삭제")
    @Transactional
    void deleteByProductId() {
        productDAO.deleteByProductId(1l);

    }
}