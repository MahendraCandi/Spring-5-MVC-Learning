package com.mahendracandi.spring5helloworldannotationsexample.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.apache.log4j.Logger;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer{
    private final static Logger log = Logger.getLogger(Initializer.class);
    
    @Override
    protected Class<?>[] getRootConfigClasses() {
        log.info("--------GET ROOT INFO CLASS----------");
        return new Class[] {AppConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        log.info("--------GET SERVLET CONFIG CLASS----------");
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        log.info("--------GET SERVLET MAPPING----------");
        return new String[] {"/"};
    }

    // When used implements WebApplicationInitializer 
//    @Override
//    public void onStartup(ServletContext sc) throws ServletException {
//        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//        context.register(AppConfig.class);
//        context.setServletContext(sc);
//        
//        ServletRegistration.Dynamic servlet = sc.addServlet("dispatcher", new DispatcherServlet(context));
//        
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//    }

}
