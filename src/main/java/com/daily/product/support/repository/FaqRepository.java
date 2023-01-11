package com.daily.product.support.repository;

import com.daily.product.support.domain.faq.Faq;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FaqRepository extends JpaRepository<Faq, Long> {
    List<Faq> findByTypeId(Long typeId);

    // outer join
    @EntityGraph("faqWithType")
    List<Faq> findAll();

    // inner join
    @Query(value = "SELECT f FROM faq f JOIN FETCH f.faqType")
    List<Faq> findAllByInnerFetchJoin();
}
