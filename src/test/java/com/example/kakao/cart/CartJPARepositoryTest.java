package com.example.kakao.cart;

import com.example.kakao.product.Product;
import com.google.gson.*;
import org.hibernate.proxy.HibernateProxy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@DataJpaTest
public class CartJPARepositoryTest {

    @Autowired
    private CartJPARepository cartJPARepository;

    @Test
    public void findAllByUserId() {

        List<Cart> cartList = cartJPARepository.findAllByUserId(1);

        // 커스텀 Gson 인스턴스 생성
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(HibernateProxy.class, new HibernateProxyTypeAdapter())
                .create();

        // JSON으로 변환
        String result = gson.toJson(cartList);

        System.out.println(result);
    }
    @Test
    public void findProductsInCartByUserId(){
        List<Product> productList = cartJPARepository.findProductsInCartByUserId(1);
        Gson gson = new GsonBuilder()
                .registerTypeHierarchyAdapter(HibernateProxy.class, new HibernateProxyTypeAdapter())
                .create();
        String result = gson.toJson(productList);

        System.out.println(result);
    }

}


// Hibernate 프록시 객체를 처리할 수 있는 커스텀 타입 어댑터
class HibernateProxyTypeAdapter implements JsonSerializer<HibernateProxy> {
    @Override
    public JsonElement serialize(HibernateProxy src, Type typeOfSrc, JsonSerializationContext context) {
        // Hibernate 프록시 객체를 처리하는 로직을 작성
        // 예를 들어, 프록시 객체를 실제 엔티티 객체로 변환한 후 직렬화할 수 있습니다.
        // 이 예제에서는 빈 JSON 객체로 대체합니다.
        return JsonNull.INSTANCE;
    }


}
