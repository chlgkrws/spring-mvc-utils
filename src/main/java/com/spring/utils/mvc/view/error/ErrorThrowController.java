package com.spring.utils.mvc.view.error;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error/throw")
public class ErrorThrowController {

    @RequestMapping("/runtime")
    public void throwRuntimeException() {

        throw new RuntimeException();
    }
}
