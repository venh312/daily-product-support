package com.daily.product.support.controller;

import com.daily.product.support.dto.*;
import com.daily.product.support.service.FaqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/faq")
@RequiredArgsConstructor
@Tag(name = "FAQ", description = "FAQ, FAQ TYPE API 명세서")
public class FaqController {
    private final FaqService faqService;

    @Operation(summary = "[FAQ TYPE] 등록")
    @PostMapping("/type")
    public ResponseEntity<Long> saveType(FaqTypeSaveRequestDto requestDto) {
        return ResponseEntity.ok(faqService.saveType(requestDto));
    }

    @Operation(summary = "[FAQ TYPE] 목록")
    @GetMapping("/type")
    public ResponseEntity<List<FaqTypeResultDto>> findAllByType() {
        return ResponseEntity.ok(faqService.findAllByType());
    }

    @Operation(summary = "[FAQ TYPE] 수정")
    @PatchMapping("/type")
    public ResponseEntity<Boolean> updateType(FaqTypeUpdateRequestDto requestDto) {
        return ResponseEntity.ok(faqService.updateType(requestDto));
    }

    @Operation(summary = "[FAQ TYPE] 삭제")
    @DeleteMapping("/type")
    public ResponseEntity deleteType(Long id) {
        faqService.deleteType(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "[FAQ] 등록")
    @PostMapping
    public ResponseEntity<Long> saveFaq(FaqSaveRequestDto requestDto) {
        return ResponseEntity.ok(faqService.saveFaq(requestDto));
    }

    @Operation(summary = "[FAQ] Type으로 조회")
    @GetMapping("/{typeId}")
    public ResponseEntity<List<FaqResultDto>> findByTypeId(@PathVariable Long typeId) {
        return ResponseEntity.ok(faqService.findByTypeId(typeId));
    }

    @Operation(summary = "[FAQ] 수정")
    @PatchMapping
    public ResponseEntity<Boolean> updateFaq(FaqUpdateRequestDto requestDto) {
        return ResponseEntity.ok(faqService.updateFaq(requestDto));
    }

    @Operation(summary = "[FAQ] 삭제")
    @DeleteMapping
    public ResponseEntity deleteById(Long id) {
        faqService.deleteFaq(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
