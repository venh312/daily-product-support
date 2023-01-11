package com.daily.product.support.repository;

import com.daily.product.support.domain.faq.type.FaqType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaqTypeRepository extends JpaRepository<FaqType, Long> {
}
