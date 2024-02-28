package com.exampe.exceptiondemo.exception;


import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Slf4j
@Controller
public class ServletExceptionController {

    @GetMapping("/test")
    public void test() {
        throw new RuntimeException("에러발생");
    }


    @GetMapping("/exception-404")
    public void test2(HttpServletResponse response) throws IOException {
        response.sendError(404,"404error");
    }


    @GetMapping("/exception-500")
    public void test3(HttpServletResponse response) throws IOException {
        response.sendError(500,"500error");
    }
}
