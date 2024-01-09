package jpabook.jpashop;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.service.MemberService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Fail.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional  // 스프링에서 Transactional 은 Default 로 rollback 이 설정되어 있음
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    @Rollback(value = false) // transactional 이 기본적으로 롤백해주므로 실제로 쿼리에 insert 가 안나감 그래서 이걸 추가해줘야 험
    public void 회원가입() throws Exception {

        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test
    public void 중복_회x원_예외() throws  Exception {

        //given
        Member member1 = new Member();
        member1.setName("kim2");

        Member member2 = new Member();
        member2.setName("kim2");

        //when
        memberService.join(member1);

       // memberService.join(member2); // 예외가 발생함

       Assertions.assertThrows(IllegalStateException.class, () ->
            memberService.join(member2) // 예외가 발생한걸 try catch 해서 넘기므로 오류가 발생하지 않음
        );

        //then
       //fail("예외가 발생해야 한다.");  // Junit5 에서는 fail 을 넣으면 테스트가 실패되게 된다
    }
}
