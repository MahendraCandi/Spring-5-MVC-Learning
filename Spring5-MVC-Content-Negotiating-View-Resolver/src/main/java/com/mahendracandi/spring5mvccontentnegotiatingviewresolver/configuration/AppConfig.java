package com.mahendracandi.spring5mvccontentnegotiatingviewresolver.configuration;

import com.mahendracandi.spring5mvccontentnegotiatingviewresolver.model.Pizza;
import com.mahendracandi.spring5mvccontentnegotiatingviewresolver.viewresolver.ExcelViewResolver;
import com.mahendracandi.spring5mvccontentnegotiatingviewresolver.viewresolver.Jaxb2MarshallingXmlViewResolver;
import com.mahendracandi.spring5mvccontentnegotiatingviewresolver.viewresolver.JsonViewResolver;
import com.mahendracandi.spring5mvccontentnegotiatingviewresolver.viewresolver.PdfViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mahendracandi.spring5mvccontentnegotiatingviewresolver")
public class AppConfig implements WebMvcConfigurer {

    /**
     * configure contentNegotiationManager
     * @param configurer
     */
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(MediaType.TEXT_HTML);
    }

    /**
     * configure contentNegotiationViewResolver
     * @return
     */
    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager){
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        //define all possible view resolvers
        List<ViewResolver> resolvers =new ArrayList<>();

        resolvers.add(jaxb2MarshallingXmlViewResolver());
        resolvers.add(jsonViewResolver());
        resolvers.add(pdfViewResolver());
        resolvers.add(excelViewResolver());
        resolvers.add(jspViewResolver());

        resolver.setViewResolvers(resolvers);
        return resolver;
    }

    /**
     * Configure View resolver to provide XML output Uses JAXB2 marshaller to
     * marshall/unmarshall POJO's (with JAXB annotations) to XML
     * @return
     */
    @Bean
    public ViewResolver jaxb2MarshallingXmlViewResolver(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Pizza.class);
        return new Jaxb2MarshallingXmlViewResolver(marshaller);
    }

    @Bean
    public ViewResolver jsonViewResolver(){
        return new JsonViewResolver();
    }

    @Bean
    public ViewResolver pdfViewResolver(){
        return new PdfViewResolver();
    }

    @Bean
    public ViewResolver excelViewResolver(){
        return new ExcelViewResolver();
    }

    @Bean
    public ViewResolver jspViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
    }
}
