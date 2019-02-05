package com.mahendracandi.spring5apachetiles.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.mahendracandi.spring5apachetiles")
public class AppConfig implements WebMvcConfigurer {
    private final static Logger log = Logger.getLogger(AppConfig.class);

    /**
     * Configure Tiles Configurer
     * @return
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

    /**
     * configure viewResolver to deliver preferred views
     * view name yg di return dari controller akan diperlakukan sebagai tiles view
     * dan Spring akan melihat definisi nama yg sama pada pengaturan xml file
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        TilesViewResolver viewResolver = new TilesViewResolver();
        registry.viewResolver(viewResolver);
    }

    /**
     * Configurer resources handler
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /*registry
                .addResourceHandler("/static/**", "/webjars/**")
                .addResourceLocations("/static/", "/webjars/");*/
        registry
                .addResourceHandler("/static/**")
                .addResourceLocations("/static/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("/webjars/");
        log.info( "MAPPING STATIC: " + registry.hasMappingForPattern("/static/**"));
        log.info( "MAPPING WEBJARS: " + registry.hasMappingForPattern("/webjars/**"));
    }
}
