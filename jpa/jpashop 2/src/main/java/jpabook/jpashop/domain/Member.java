package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.ArrayList;

@Entity
@Getter @Setter
public class Member {
     @Id
     @GeneratedValue
     @Column(name = "member_id")
     private Long id;

     private String name;

     @Embedded
     private Address address;

     @OneToMany(mappedBy = "member") /* order table 에 있는 member 을 의미함 */
     private List<Order> orders = new ArrayList<>(); /* 이렇게 선언한 컬렉션은 왠만하면 변경하지 않는 것이 좋다.*/

}
