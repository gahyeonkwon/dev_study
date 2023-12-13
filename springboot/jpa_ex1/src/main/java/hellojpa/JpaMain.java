package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // persistence.xml  에 있는  unitName 기재

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // jpa 에서 데이터 변경하기
            /*Member memberUp = em.find(Member.class, 150L);
            memberUp.setName("이름변경하기");*/

            // 엔티티 삭제하기
           /*
            Member memberA = em.find(Member.class, "1");
            em.remove(memberA); */

            /*//영속
            Member member1 = new Member(150L, "A");
            Member member2 = new Member(150L, "B");

            // 이 시점에 데이터베이스에 바로 저장 되는게 아님
            em.persist(member1);
            em.persist(member2);

            tx.commit();*/

            //비영속
            /*Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");

            //영속
            em.persist(member);*/

            /*jpql*/


            /* 데아터 변경해보기
            Member findMember = em.find(Member.class, 1L);
            findMember.setName("updateJPA");*/

            /* 데이터 삽입해보기

            ember member = new Member();
            member.setId(1L);
            member.setName("HelloA");

            em.persist(member);*/

            //tx.commit();

            //TestMember 생성해보기
            Member tm = new Member("name1", 10);
            em.persist(tm);

            Member tm2 = new Member("name2", 10);
            em.persist(tm2);

            Member tm3 = new Member("name3", 10);
            em.persist(tm3);

            Member tm4 = new Member("name4", 10);
            em.persist(tm4);


            tx.commit();

        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
