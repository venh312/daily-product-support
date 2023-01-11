package com.daily.product.support.controller;

import com.daily.product.support.dto.FaqTypeRequestDto;
import com.daily.product.support.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import java.util.Collections;

@SpringBootTest
class FaqTypeTest {
    @Autowired
    private FaqService faqService;

    @Test
    void faqType_저장_테스트() {
        FaqTypeRequestDto requestDto = new FaqTypeRequestDto();
        requestDto.setName("ZigZaG");
        Assert.notEmpty(Collections.singleton(faqService.saveType(requestDto)), "Empty saveType();");
    }

    @Test
    void faqType_수정_테스트() {
        FaqTypeRequestDto requestDto = new FaqTypeRequestDto();
        requestDto.setId(1L);
        requestDto.setName("ZigZaG");
        Assert.isTrue(faqService.updateType(requestDto), "Empty updateType();");
    }

    @Test
    void faqType_조회_테스트() {
        Assert.notEmpty(faqService.findAllByType(), "Empty updateType();");
    }

    @Test
    void faqType_삭제_테스트() {
        FaqTypeRequestDto requestDto = new FaqTypeRequestDto();
        requestDto.setId(6L);
        faqService.deleteType(requestDto);
    }
}