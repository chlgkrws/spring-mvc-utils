package com.spring.utils.mvc.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

//@Configuration
public class ErrorConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    /*
    -------------------------상속받지 않고 사용하는 방법-----------------------
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();

        // 404, RuntimeException 에러 -> 서블릿에 등록
        ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-404");
        ErrorPage errorRTE = new ErrorPage(RuntimeException.class, "/error/runtime");

        factory.addErrorPages(error404);
        factory.addErrorPages(errorRTE);
        return factory;
    }*/

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        // 404, RuntimeException 에러 -> 서블릿에 등록
        ErrorPage error404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        ErrorPage error500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        ErrorPage errorRTE = new ErrorPage(RuntimeException.class, "/error/runtime");

        factory.addErrorPages(error404, error500, errorRTE);
    }
}
