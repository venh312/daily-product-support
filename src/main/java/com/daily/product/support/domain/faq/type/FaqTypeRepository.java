package com.daily.product.support.domain.faq.type;

import com.daily.product.support.domain.faq.Faq;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FaqTypeRepository extends JpaRepository<FaqType, Long> {
    @Query(value = "SELECT distinct f FROM FaqType f JOIN FETCH f.faqs", nativeQuery = true)
    List<FaqType> findAllByFetchJoin();
}
