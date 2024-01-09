package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final EntityManager em;

    public void save(Order order) {
        em.persist(order);
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }

    /*public List<Order> findAll(OrderSearch orderSearch) {

        em.createQuery("select o from Order o join o.member m"
                        + "where o.status = :status"
                        + "and m.name like :name", Order.class)
                .setParameter("status", orderSearch.getOrderStatus())
                .setParameter("name", orderSearch.getMemberName())
                .setMaxResults(1000) // 최대 천건 ( 페이징할 때 사용 )
                .getResultList();

        // -- 위 코드처럼 작성할 경우 name 이랑 status 값이 없을 경우 오류가 남 그래서 동적 쿼리를 따로 분리해서 짜줘야함
        // --> querydsl 로 변경 
    }*/

}
