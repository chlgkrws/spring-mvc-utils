package com.spring.utils.mvc.view.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/500")
    public ModelAndView error500(ModelAndView modelAndView) {
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

}
