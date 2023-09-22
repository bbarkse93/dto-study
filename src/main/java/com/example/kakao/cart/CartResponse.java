package com.example.kakao.cart;

import com.example.kakao.product.Product;
import com.example.kakao.product.option.Option;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

public class CartResponse {

    // (기능3) 장바구니 조회
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTO {
        private Integer totalPrice;
        private List<ProductDTO> products;

        public FindAllByUserDTO(List<Cart> carts) {
            this.totalPrice = carts.stream().mapToInt(cart -> cart.getPrice()).sum();
            this.products = carts.stream()
                    .map(cart -> cart.getOption().getProduct()).distinct()
                    .map(product -> new ProductDTO(product, carts))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public class ProductDTO {
            private Integer productId;
            private String productName;
            private List<CartDTO> carts;

            public ProductDTO(Product product, List<Cart> carts) {
                this.productId = product.getId();
                this.productName = product.getProductName();
                this.carts = carts.stream()
                        .filter(cart -> cart.getOption().getProduct().getId() == product.getId())
                        .map(c -> new CartDTO(c))
                        .collect(Collectors.toList());
            }

            @Getter
            @Setter
            public class CartDTO {
                private Integer cartId;
                private Integer quantity;
                private Integer cartPrice;
                private Option option;

                public CartDTO(Cart cart) {
                    this.cartId = cart.getId();
                    this.quantity = cart.getQuantity();
                    this.cartPrice = cart.getPrice();
                    this.option = cart.getOption();
                }
            }
        }
    }

    // (기능3) 장바구니 조회 (풀이)
    @ToString
    @Getter
    @Setter
    public static class FindAllByUserDTOT {
        private Integer totalPrice;
        private List<ProductDTO> products;

        public FindAllByUserDTOT(List<Cart> cartList) {
            this.totalPrice = cartList.stream().mapToInt(cart -> cart.getPrice()).sum();
            this.products = cartList.stream()
                    .map(cart -> cart.getOption().getProduct()).distinct()
                    .map(product -> new ProductDTO(product, cartList))
                    .collect(Collectors.toList());
        }

        @Getter
        @Setter
        public class ProductDTO {
            private Integer productId;
            private String productName;
            private List<CartDTO> carts;

            public ProductDTO(Product product, List<Cart> carts) {
                this.productId = product.getId();
                this.productName = product.getProductName();
                this.carts = carts.stream()
                        .filter(cart -> cart.getOption().getProduct().getId() == product.getId())
                        .map(cart -> new CartDTO(cart))
                        .collect(Collectors.toList());
            }

            @Getter
            @Setter
            public class CartDTO {
                private Integer cartId;
                private String cartOptionName;
                private Integer cartQuantity;
                private Integer cartPrice;

                public CartDTO(Cart cart) {
                    this.cartId = cart.getId();
                    this.cartOptionName = cart.getOption().getOptionName();
                    this.cartQuantity = cart.getQuantity();
                    this.cartPrice = cart.getPrice();
                }
            }
        }
    }
}


