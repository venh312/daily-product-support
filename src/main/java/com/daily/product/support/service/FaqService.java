package com.daily.product.support.service;

import com.daily.product.support.domain.faq.Faq;
import com.daily.product.support.domain.faq.FaqRepository;
import com.daily.product.support.domain.faq.type.FaqType;
import com.daily.product.support.domain.faq.type.FaqTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FaqService {
    private final FaqRepository faqRepository;
    private final FaqTypeRepository faqTypeRepository;

    public List<Faq> findAllFaq() {
        return faqRepository.findAll();
    }
    public List<FaqType> findAllFaqType() {
        return faqTypeRepository.findAllByFetchJoin();
    }
}
