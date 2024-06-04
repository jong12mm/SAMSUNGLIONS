package com.example.sl.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig  implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/js/**").addResourceLocations("classpath:/static/js/"); //.setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/static/css/**").addResourceLocations("classpath:/static/css/"); //.setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/static/assets/**").addResourceLocations("classpath:/static/assets/"); //.setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/static/img/**").addResourceLocations("classpath:/static/img/");//.setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/static/font/**").addResourceLocations("classpath:/static/font/");//.setCachePeriod(60*60*24*365);


        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js/"); //.setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/css/"); //.setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/assets/"); //.setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/img/**").addResourceLocations("classpath:/static/img/");//.setCachePeriod(60*60*24*365);
        registry.addResourceHandler("/font/**").addResourceLocations("classpath:/static/font/");//.setCachePeriod(60*60*24*365);
    }
}
