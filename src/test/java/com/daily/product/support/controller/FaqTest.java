package com.daily.product.support.controller;

import com.daily.product.support.dto.FaqSaveRequestDto;
import com.daily.product.support.dto.FaqUpdateRequestDto;
import com.daily.product.support.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import java.util.Collections;

@SpringBootTest
public class FaqTest {
    @Autowired
    private FaqService faqService;

    @Test
    void faq_저장_테스트() {
        FaqSaveRequestDto requestDto = new FaqSaveRequestDto();
        requestDto.setTypeId(1L);
        requestDto.setTitle("테스트");
        requestDto.setContents("내용테스트");
        requestDto.setRegisterId(1L);
        Assert.notEmpty(Collections.singleton(faqService.saveFaq(requestDto)), "실패 faq_저장_테스트");
    }

    @Test
    void faq_조회_테스트() {
        Assert.notEmpty(faqService.findByTypeId(1L), "실패 faq_조회_테스트");
    }

    @Test
    void faq_수정_테스트() {
        FaqUpdateRequestDto requestDto = new FaqUpdateRequestDto();
        requestDto.setId(1L);
        requestDto.setTypeId(1L);
        requestDto.setTitle("수정제목");
        requestDto.setContents("일반내용");
        requestDto.setModifyId(1L);
        Assert.isTrue(faqService.updateFaq(requestDto), "실패 faq_수정_테스트");
    }

    @Test
    void faq_삭제_테스트() {
        faqService.deleteFaq(4L);
    }
}
