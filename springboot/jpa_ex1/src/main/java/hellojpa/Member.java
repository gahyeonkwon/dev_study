package hellojpa;

import javax.persistence.*;


@Entity
@SequenceGenerator(name = "member_seq_generator", sequenceName = "member_seq", allocationSize = 50)
@Table(name = "autocreatemember")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_generator")
    private Long id;
    private String name;

    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Member() {

    }

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Member(long id, String name, int age) {

        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
