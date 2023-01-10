package com.daily.product.support.service;

import com.daily.product.support.domain.faq.Faq;
import com.daily.product.support.domain.faq.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FaqService {
    private final FaqRepository faqRepository;

    public List<Faq> findAllFaq() {
        return faqRepository.findAll();
    }
}
