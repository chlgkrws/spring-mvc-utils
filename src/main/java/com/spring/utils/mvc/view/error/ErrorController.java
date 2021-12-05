package com.spring.utils.mvc.view.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
@RequestMapping("/error")
public class ErrorController {

    //RequestDispatcher 상수로 정의되어 있음
    public static final String ERROR_EXCEPTION =
            "javax.servlet.error.exception";
    public static final String ERROR_EXCEPTION_TYPE =
            "javax.servlet.error.exception_type";
    public static final String ERROR_MESSAGE = "javax.servlet.error.message";
    public static final String ERROR_REQUEST_URI =
            "javax.servlet.error.request_uri";
    public static final String ERROR_SERVLET_NAME =
            "javax.servlet.error.servlet_name";
    public static final String ERROR_STATUS_CODE =
            "javax.servlet.error.status_code";


    @RequestMapping("/500")
    public ModelAndView error500(ModelAndView modelAndView, HttpServletRequest request) {
        //예외 정보 출력 예제
        printErrorInfo(request);
        log.info("DispatcherType of Call of ErrorPage ::::: {}",request.getDispatcherType());
        modelAndView.setViewName("error/error-500");
        return modelAndView;
    }

    @RequestMapping("/404")
    public ModelAndView error400(ModelAndView modelAndView) {
        modelAndView.setViewName("error/error-404");
        return modelAndView;
    }

    @RequestMapping("/runtime")
    public ModelAndView errorRTE(ModelAndView modelAndView) {
        modelAndView.setViewName("error/runtime");
        return modelAndView;
    }

    private void printErrorInfo(HttpServletRequest request) {
        log.info("ERROR_EXCEPTION: ex=",
                request.getAttribute(ERROR_EXCEPTION));
        log.info("ERROR_EXCEPTION_TYPE: {}",
                request.getAttribute(ERROR_EXCEPTION_TYPE));
        log.info("ERROR_MESSAGE: {}", request.getAttribute(ERROR_MESSAGE)); // ex의 경우 NestedServletException 스프링이 한번 감싸서 반환
        log.info("ERROR_REQUEST_URI: {}",
                request.getAttribute(ERROR_REQUEST_URI));
        log.info("ERROR_SERVLET_NAME: {}",
                request.getAttribute(ERROR_SERVLET_NAME));
        log.info("ERROR_STATUS_CODE: {}",
                request.getAttribute(ERROR_STATUS_CODE));
        log.info("dispatchType={}", request.getDispatcherType());
    }

}
