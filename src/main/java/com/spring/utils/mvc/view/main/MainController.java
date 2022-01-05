package com.spring.utils.mvc.view.main;

import com.spring.utils.mvc.convert.type.IpPort;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;

@Controller
public class MainController {

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView, @RequestParam(required = false) Integer text) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping("/form/test")
    public ModelAndView getForm(ModelAndView modelAndView) {

        IpPort ipPort = new IpPort("127.0.0.1", 8080);
        Form form = new Form(ipPort);

        modelAndView.addObject("form", form);
        modelAndView.setViewName("form");
        return modelAndView;
    }

    @PostMapping("/form/test")
    public ModelAndView createForm(ModelAndView modelAndView, @ModelAttribute Form form) {

        IpPort ipPort = form.getIpPort();

        modelAndView.addObject("ipPort", ipPort);
        modelAndView.setViewName("form");
        return modelAndView;
    }

    @Data
    static class Form {
        private IpPort ipPort;

        public Form(IpPort ipPort) {
            this.ipPort = ipPort;
        }
    }
}
