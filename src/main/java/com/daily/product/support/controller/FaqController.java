package com.daily.product.support.controller;

import com.daily.product.support.dto.FaqRequestDto;
import com.daily.product.support.dto.FaqResultDto;
import com.daily.product.support.dto.FaqTypeRequestDto;
import com.daily.product.support.dto.FaqTypeResultDto;
import com.daily.product.support.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/faq")
@RequiredArgsConstructor
public class FaqController {
    private final FaqService faqService;

    @PostMapping("/type")
    public ResponseEntity<Long> saveType(FaqTypeRequestDto requestDto) {
        return ResponseEntity.ok(faqService.saveType(requestDto));
    }

    @GetMapping("/type")
    public ResponseEntity<List<FaqTypeResultDto>> findAllByType() {
        return ResponseEntity.ok(faqService.findAllByType());
    }

    @PatchMapping("/type")
    public ResponseEntity<Boolean> updateType(FaqTypeRequestDto requestDto) {
        return ResponseEntity.ok(faqService.updateType(requestDto));
    }

    @DeleteMapping("/type")
    public ResponseEntity deleteType(FaqTypeRequestDto requestDto) {
        faqService.deleteType(requestDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> saveFaq(FaqRequestDto requestDto) {
        return ResponseEntity.ok(faqService.saveFaq(requestDto));
    }

    @GetMapping("/{typeId}")
    public ResponseEntity<List<FaqResultDto>> findByTypeId(@PathVariable Long typeId) {
        return ResponseEntity.ok(faqService.findByTypeId(typeId));
    }

    @PatchMapping
    public ResponseEntity<Boolean> updateFaq(FaqRequestDto requestDto) {
        return ResponseEntity.ok(faqService.updateFaq(requestDto));
    }

    @DeleteMapping
    public ResponseEntity deleteById(FaqRequestDto requestDto) {
        faqService.deleteFaq(requestDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
