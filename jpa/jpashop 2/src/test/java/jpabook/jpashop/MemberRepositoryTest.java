package jpabook.jpashop;

import jakarta.transaction.Transactional;

import jpabook.jpashop.repository.MemberRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;


@SpringBootTest
class MemberRepositoryTest {

        @Autowired
        MemberRepository memberRepository;


        @Test
        @Transactional
        @Rollback(false)
        public void testMember() throws Exception {

            //given
//            Member member = new Member();
//            member.setName("memberA");
//
//            //when
//            Long savedId = memberRepository.save(member);
//            Member findMember = memberRepository.find(savedId);
//
//            //then
//            Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
//            Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
//            Assertions.assertThat(findMember).isEqualTo(member);
//
//

        }
}