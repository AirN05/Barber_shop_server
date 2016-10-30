package com.server;

import com.server.config.WebConfig;
import com.server.repository.RemindRepository;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer{

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext stx=new AnnotationConfigWebApplicationContext();
        stx.register(WebConfig.class);
        servletContext.addListener(new ContextLoaderListener(stx));

        ServletRegistration.Dynamic servlet=servletContext.addServlet("dispatcher", new DispatcherServlet(stx));
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);


    }
}
