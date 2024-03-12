package study.querydsl.controller;


import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import study.querydsl.entity.Member;
import study.querydsl.entity.Team;

@Profile("local") // application.yml  에 있는 profile 이 local 설정에 대하여 하단 코드가 초기화 됨.
@Component
@RequiredArgsConstructor
public class InitMember {

    private  final InitMemberService initMemberService;

    @PostConstruct // postContructor 과 Transaction 이 동작하는 부분을 함께 넣을 수 없기 때문에 굳이 분리해서 설정해줌
    public void init(){
        initMemberService.init();
    }

    @Component
    static class InitMemberService {
        @PersistenceContext
        private EntityManager em;

        @Transactional
        public void init() {
            Team teamA = new Team("teamA");
            Team teamB = new Team("teamB");
            em.persist(teamA);
            em.persist(teamB);

            for(int i=0; i < 100; i++) {
                Team selectedTeam = i % 2 == 0 ? teamA : teamB;
                em.persist(new Member(("member" + i), i , selectedTeam));
            }
        }

    }
}
