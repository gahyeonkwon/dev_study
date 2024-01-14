package study.querydsl.controller;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import study.querydsl.entity.Member;
import study.querydsl.entity.Team;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public void hello() {
        System.out.println("hello");
    }
}
