package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) /* 상속관계에서 테이블들을 표현하는 방식 */
@DiscriminatorColumn(name = "dtype") /* 자식 테이블을 구분하기 위한 값 */
@Getter @Setter
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category>  categories = new ArrayList<>();


    //== 비즈니스 로직 ==//

    /**
     * stock 증가
     * */
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }


    /**
     *
     * stock 감소
     */
    public void removeStock(int quantity) {

        int restStock = this.stockQuantity - quantity;
        if(restStock < 0 ) {
            throw new NotEnoughStockException("need more stock");
        }

        this.stockQuantity = restStock;
    }


}
