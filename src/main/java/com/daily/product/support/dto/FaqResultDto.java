package com.daily.product.support.dto;

import com.daily.product.support.domain.BaseTime;
import com.daily.product.support.domain.faq.Faq;
import lombok.Getter;

@Getter
public class FaqResultDto {
    private Long id;
    private Long typeId;
    private String title;
    private String contents;
    private Long registerId;
    private String registerTime;

    public FaqResultDto(Faq f) {
        this.id = f.getId();
        this.typeId = f.getTypeId();
        this.title = f.getTitle();
        this.contents = f.getContents();
        this.registerId = f.getRegisterId();
        this.registerTime = BaseTime.toStringDateTime(f.getRegisterTime());
    }
}
