package com.daily.product.support.dto;

import com.daily.product.support.domain.faq.type.FaqType;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FaqTypeSaveRequestDto {
    private String name;

    public FaqType toEntity() {
        return FaqType.builder().name(name).build();
    }
}
