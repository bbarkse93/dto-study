package com.example.kakao.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@DataJpaTest
public class ProductJPARepositoryTest {

    @Autowired
    private ProductJPARepository productJPARepository;
//    @Test
//    public void findAllByUserId(@RequestBody Integer userId){
//       List<Product> productList = productJPARepository.findAllByUserId(1);
//        System.out.println(productList);
//    }
}
