package com.daily.product.support.service;

import com.daily.product.support.domain.faq.Faq;
import com.daily.product.support.domain.faq.type.FaqType;
import com.daily.product.support.dto.*;
import com.daily.product.support.repository.FaqRepository;
import com.daily.product.support.repository.FaqTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class FaqService {
    private final FaqRepository faqRepository;
    private final FaqTypeRepository faqTypeRepository;

    public Long saveType(FaqTypeSaveRequestDto requestDto) {
        return faqTypeRepository.save(requestDto.toEntity()).getId();
    }

    public List<FaqTypeResultDto> findAllByType() {
        return faqTypeRepository.findAll().stream().map(FaqTypeResultDto::new).collect(Collectors.toList());
    }

    @Transactional
    public boolean updateType(FaqTypeUpdateRequestDto requestDto) {
        Optional<FaqType> faqType = faqTypeRepository.findById(requestDto.getId());
        if (faqType.isPresent()) {
            faqType.get().update(requestDto.getName());
            return true;
        }
        return false;
    }

    public void deleteType(Long id) {
        faqTypeRepository.deleteById(id);
    }

    public Long saveFaq(FaqSaveRequestDto requestDto) {
        return faqRepository.save(requestDto.toEntity()).getId();
    }

    public List<FaqResultDto> findByTypeId(Long typeId) {
        return faqRepository.findByTypeId(typeId).stream().map(FaqResultDto::new).collect(Collectors.toList());
    }

    @Transactional
    public boolean updateFaq(FaqUpdateRequestDto requestDto) {
        Optional<Faq> faq = faqRepository.findById(requestDto.getId());
        if (faq.isPresent()) {
            faq.get().update(requestDto.getTypeId(), requestDto.getTitle(), requestDto.getContents(), requestDto.getModifyId());
            return true;
        }
        return false;
    }

    public void deleteFaq(Long id) {
        faqRepository.deleteById(id);
    }
}
