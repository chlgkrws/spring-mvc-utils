package com.spring.utils.mvc.view.error;


import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

/**
 * 예외 던지기 용 예제 컨트롤러
 */
@Controller
@RequestMapping("/error/throw")
public class ErrorThrowController {

    @RequestMapping("/runtime")
    public void throwRuntimeException() {

        throw new RuntimeException();
    }

    @RequestMapping("/sendError")
    public void throwSendError(HttpServletResponse response) throws Exception {

        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Throw Server Exception");
    }


}
