package com.daily.product.support.web;

import com.daily.product.support.domain.faq.Faq;
import com.daily.product.support.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/support")
@RequiredArgsConstructor
public class SupportController {
    private final FaqService faqService;

    @GetMapping("/faq")
    public ResponseEntity<List<Faq>> findAllFaq() {
        return ResponseEntity.ok(faqService.findAllFaq());
    }

}
