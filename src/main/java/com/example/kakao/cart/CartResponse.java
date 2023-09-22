package com.example.kakao.cart;

import com.example.kakao.product.Product;
import com.example.kakao.product.option.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public class CartResponse{

    // (기능3) 장바구니 조회
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
       private Integer totalPrice;
       private List<ProductDTO> products;

        public FindAllByUserDTO(Integer totalPrice, List<Product> products, List<Cart> carts) {
            this.totalPrice = totalPrice;
            this.products = products.stream()

                    .map(p -> {
                        return new ProductDTO(p, carts);
                    })
                    .collect(Collectors.toList());
        }

        @Getter @Setter
        public class ProductDTO{
            private Integer productId;
            private String productName;
            private List<CartDTO> carts;

            public ProductDTO(Product product, List<Cart> carts) {
                this.productId = product.getId();
                this.productName = product.getProductName();
                this.carts = carts.stream()
                        .map(c -> new CartDTO(c) )
                        .collect(Collectors.toList());
            }
            @Getter @Setter
            public class CartDTO{
                private Integer CartId;
                private Integer quantity;
                private Integer cartPrice;
                private Option option;

                public CartDTO(Cart cart) {
                    CartId = cart.getId();
                    this.quantity = cart.getQuantity();
                    this.cartPrice = cart.getPrice();
                    this.option = cart.getOption();
                }
            }
        }
    }
}
