package com.mahendracandi.spring5mvccontentnegotiatingviewresolver.viewresolver;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

public class ExcelViewResolver implements ViewResolver {
    private final static Logger log = Logger.getLogger(ExcelViewResolver.class);

    @Override
    public View resolveViewName(String s, Locale locale) throws Exception {
        log.info("*************INI S: " + s);
        log.info("*************INI LOCALE: " + locale);
        ExcelView excelView = new ExcelView();
        return excelView;
    }
}
