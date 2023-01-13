package com.daily.product.support.dto;

import com.daily.product.support.domain.faq.Faq;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FaqUpdateRequestDto {
    private Long id;
    private Long typeId;
    private String title;
    private String contents;
    private Long modifyId;

    public Faq toEntity() {
        return Faq.builder()
            .typeId(typeId)
            .title(title)
            .contents(contents)
            .modifyId(modifyId)
            .build();
    }
}
