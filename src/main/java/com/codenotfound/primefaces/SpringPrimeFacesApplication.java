package com.codenotfound.primefaces;

import dom.sv.ane.slusaci.SlusacAplikacije;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringPrimeFacesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPrimeFacesApplication.class, args);
    }

    // Register ServletContextListener
    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> listenerRegistrationBean() {
        ServletListenerRegistrationBean<ServletContextListener> bean
                = new ServletListenerRegistrationBean<>();
        bean.setListener(new SlusacAplikacije());
        return bean;

    }

    @Bean
    public ServletContextInitializer initializer() {
        return new ServletContextInitializer() {

            @Override
            public void onStartup(ServletContext servletContext) throws ServletException {
                servletContext.setInitParameter("konfiguracija", "conf.xml");
            }

        };
    }

}
