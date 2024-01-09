package jpabook.jpashop.service;



import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(readOnly = true) // 스프링에 있는걸 쓰는 것을 권장
@RequiredArgsConstructor // final 에 있는 값에 대해 생성자 세팅해줌
//@Transactional(readonly = true) // 읽는 로직에는 이렇게 추가 해주는것을 권장
public class MemberService {

    private final MemberRepository memberRepository;

   /* @Autowired // 스프링빈에 등록되어있는 memberRepository 를 injection 해줌
    // 요즘엔 Autowired 안써도 생성자가 하나면 스프링에서 그냥 자동으로 injection 해줌
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }*/

    /**
     * 회원 가입
     * */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 중복회원이면 오류를 발생
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()) {
            throw  new IllegalStateException(" 이미 존재하는 회원입니다");
        }
    }

    /**
     * 회원 전체 조회
     * */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
    * 회원 한건 조회
    * */
    public Member findMember(Long id) {
        return memberRepository.findOne(id);
    }
}
