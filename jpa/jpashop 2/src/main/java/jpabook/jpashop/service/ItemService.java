package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item) {
        itemRepository.save(item);
    }

    //@Transactional
    /*public Item updateItem(Long itemId, Book bookParam) {
        Item findItem = itemRepository.findOne(itemId); // 영속성 상태 -> 변경감지에 의해 데이터가 변경되는 방법
        findItem.setPrice(bookParam.getPrice());
        findItem.setName(bookParam.getName());
        findItem.setStockQuantity(bookParam.getStockQuantity());

        return findItem;
    }*/


    @Transactional
    public void updateItem(Long itemId, String name, int price, int stockQuntity) {
        Item findItem = itemRepository.findOne(itemId); // 영속성 상태 -> 변경감지에 의해 데이터가 변경되는 방법
        findItem.setPrice(price);
        findItem.setName(name);
        findItem.setStockQuantity(stockQuntity);
    }


    public List<Item> findItems() {
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId) {
        return itemRepository.findOne(itemId);
    }
}
