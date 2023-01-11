package com.daily.product.support.domain.faq;

import com.daily.product.support.domain.BaseTime;
import com.daily.product.support.domain.faq.type.FaqType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.*;

@DynamicUpdate
@NoArgsConstructor
@NamedEntityGraph(name = "faqWithType", attributeNodes = @NamedAttributeNode("faqType"))
@Getter @Setter
@Entity(name = "faq")
public class Faq extends BaseTime {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "type_id")
    private Long typeId;
    private String title;
    private String contents;
    private Long registerId;
    private Long modifyId;

    /*
    조인 관계를 설정 후 FAQ를 조회했는데 Type까지 조회되는 이유 (N+1 문제)
    디폴트가 FetchType.EAGER으로 즉시로딩 되기 때문이다.

    따라서 지연로딩을 걸어준다면?
    FetchType.LAZY (즉시 호출하지않고 필요로 요구하는 시점에 호출된다.)
        ByteBuddyInterceptor 타입의 프록시 객체로 가져온다.
        FAQ를 호출하고 TYPE은 요청할때 불러온다. 그럼 쿼리를 FAQ 한 번 TYPE 1번 총 2번 조회한다.

        *결국 필요로 할때는 한번 더 호출 된다는 이야기
        이걸 해결하기 위해 한방 쿼리를 사용한다.
        ex) JPQL의 fetch join 방법, 엔티티그래프와 어노테이션으로 푸는 방법, 배치 사이즈 설정 방법
    */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", insertable = false, updatable = false)
    private FaqType faqType;

    @Builder
    public Faq(Long id, Long typeId, String title, String contents, Long registerId, Long modifyId) {
        this.id = id;
        this.typeId = typeId;
        this.title = title;
        this.contents = contents;
        this.registerId = registerId;
        this.modifyId = modifyId;
    }

    public void update(Long typeId, String title, String contents, Long modifyId) {
        this.typeId = typeId;
        this.title = title;
        this.contents = contents;
        this.modifyId = modifyId;
    }

}
