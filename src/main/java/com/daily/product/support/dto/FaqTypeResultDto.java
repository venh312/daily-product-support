package com.daily.product.support.dto;

import com.daily.product.support.domain.faq.type.FaqType;
import lombok.Getter;

@Getter
public class FaqTypeResultDto {
    private Long id;
    private String name;

    public FaqTypeResultDto(FaqType f) {
        this.id = f.getId();
        this.name = f.getName();
    }
}
