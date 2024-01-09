package jpabook.jpashop.domain;

import jakarta.persistence.*;
import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.*;


@Entity
@Getter @Setter
public class Category {


    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item",
                joinColumns = @JoinColumn(name = "category_id"),
                    inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items = new ArrayList<>();



    ///////////// 나 자신과 매핑 걸기 ////////////////////
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();


    // == 연관관계 편의 메서드 == //
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.setParent(this);
    }




}
