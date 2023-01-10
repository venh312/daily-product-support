package com.daily.product.support.web;

import com.daily.product.support.service.FaqService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class SupportControllerTest {
    @Autowired
    private FaqService faqService;

    @Test
    void findAllFaq() {
        Assert.notEmpty(faqService.findAllFaq(), "==> empty findAllFaq()");
    }
}