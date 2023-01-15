package com.daily.product.support.controller;

import com.daily.product.support.dto.*;
import com.daily.product.support.service.FaqService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
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
    @Parameters({
        @Parameter(name="name", description = "이름", required = true)
    })
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
    @Parameters({
        @Parameter(name="id", description = "PK", required = true),
        @Parameter(name="name", description = "이름", required = true)
    })
    @PatchMapping("/type")
    public ResponseEntity<Boolean> updateType(FaqTypeUpdateRequestDto requestDto) {
        return ResponseEntity.ok(faqService.updateType(requestDto));
    }

    @Operation(summary = "[FAQ TYPE] 삭제")
    @Parameters({
        @Parameter(name="id", description = "PK")
    })
    @DeleteMapping("/type")
    public ResponseEntity deleteType(Long id) {
        faqService.deleteType(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @Operation(summary = "[FAQ] 등록")
    @Parameters({
        @Parameter(name="typeId", description = "타입 ID", required = true),
        @Parameter(name="title", description = "제목", required = true),
        @Parameter(name="contents", description = "내용", required = true),
        @Parameter(name="registerId", description = "등록자 PK", required = true)
    })
    @PostMapping
    public ResponseEntity<Long> saveFaq(FaqSaveRequestDto requestDto) {
            System.out.println(requestDto);
        return ResponseEntity.ok(faqService.saveFaq(requestDto));
    }

    @Operation(summary = "[FAQ] 타입으로 조회")
    @GetMapping("/{typeId}")
    public ResponseEntity<List<FaqResultDto>> findByTypeId(
            @Parameter(name="typeId", description = "타입 ID", required = true)
            @PathVariable Long typeId) {
        return ResponseEntity.ok(faqService.findByTypeId(typeId));
    }

    @Operation(summary = "[FAQ] 수정")
    @Parameters({
        @Parameter(name="id", description = "PK", required = true),
        @Parameter(name="typeId", description = "타입 ID", required = true),
        @Parameter(name="title", description = "제목", required = true),
        @Parameter(name="contents", description = "내용", required = true),
        @Parameter(name="modifyId", description = "변경자 PK", required = true)
    })
    @PatchMapping
    public ResponseEntity<Boolean> updateFaq(FaqUpdateRequestDto requestDto) {
        return ResponseEntity.ok(faqService.updateFaq(requestDto));
    }

    @Operation(summary = "[FAQ] 삭제")
    @DeleteMapping
    public ResponseEntity deleteById(
            @Parameter(name="id", description = "PK", required = true)
            Long id) {
        faqService.deleteFaq(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
