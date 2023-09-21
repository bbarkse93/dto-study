package com.example.kakao.product;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.kakao.product.option.Option;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class ProductResponse {

    // (기능1) 상품 목록보기
    @ToString
    @Getter
    @Setter
    public static class FindAllDTO {
        private Integer id;
        private String productName;
        private String image;
        private Integer price;

        public FindAllDTO(Product product) {
            this.id = product.getId();
            this.productName = product.getProductName();
            this.image = product.getImage();
            this.price = product.getPrice();
        }
    }

    // (기능2) 상품 상세보기
    @ToString
    @Getter
    @Setter
    public static class FindByIdDTO {
        private Integer productId;
        private String productName;
        private String image;
        private Integer price;
        private Integer starCount;
        private List<OptionDTO> options;

        public FindByIdDTO(Product product) {
            this.productId = product.getId();
            this.productName = product.getProductName();
            this.image = product.getImage();
            this.price = product.getPrice();
            this.starCount = 4;
            this.options = product.getOptions().stream()
                    .map(o -> new OptionDTO(o))
                    .collect(Collectors.toList());
        }

        @Getter @Setter
        public class OptionDTO{
            private Integer optionId;
            private String optionName;
            private Integer optionPrice;

            public OptionDTO(Option option) {
                this.optionId = option.getId();
                this.optionName = option.getOptionName();
                this.optionPrice = option.getPrice();
            }
        }
    }

}