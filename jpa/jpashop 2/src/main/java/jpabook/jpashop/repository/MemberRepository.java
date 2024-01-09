package jpabook.jpashop.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

 /*   @PersistenceContext // 스프링에서 제공하는 애노테이션이며 알아서 엔티티 매니저를 주입함
    private EntityManager em;*/

    // RequiredArgsConstructor 를 사용하여 선언하는 방식을 씀
    public final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from  Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
