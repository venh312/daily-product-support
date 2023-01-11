package com.daily.product.support.dto;

import com.daily.product.support.domain.faq.type.FaqType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FaqTypeRequestDto {
    private Long id;
    private String name;

    public FaqType toEntity() {
        return FaqType.builder().name(name).build();
    }
}
