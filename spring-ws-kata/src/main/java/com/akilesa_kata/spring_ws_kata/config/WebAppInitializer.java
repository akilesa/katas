package com.akilesa_kata.spring_ws_kata.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by akilesa on 04.10.15.
 */
public class WebAppInitializer implements WebApplicationInitializer
{
    @Override
    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringServiceConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootContext));

        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(SpringWebConfig.class);
        ServletRegistration.Dynamic dispatcher = servletContext
                .addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");

        AnnotationConfigWebApplicationContext wsContext = new AnnotationConfigWebApplicationContext();
        wsContext.register(SpringWsConfig.class);
        ServletRegistration.Dynamic ws = servletContext
                .addServlet("ws", new MessageDispatcherServlet(wsContext));
        ws.setLoadOnStartup(2);
        ws.addMapping("/ws/*");
    }
}
