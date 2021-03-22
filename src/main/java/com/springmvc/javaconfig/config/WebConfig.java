package com.springmvc.javaconfig.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/*
 * QUESTA CLASSE IMPOSTA IL SUPPORTO DI BASE PER UN PROGETTO SPRINGMVC CONFIGURATO INTERAMENTE IN JAVA, SENZA FILE.XML, 
 * COME LA REGISTRAZIONE DEL CONTROLLER E IL MAPPING ALLE RISORSE WEB, AI FILE STATICI (.CSS, .JS. IMG).
 * IN PRATICA SOSTITUISCE IL FILE SERVLET-CONTEXT.XML
 * 
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.springmvc.javaconfig"})
public class WebConfig implements WebMvcConfigurer {
    
    // Registra il ViewController per creare una mappatura diretta tra un percorso URL e un nome di view (home.jsp)
    // senza la necessità di un controller intermedio. 
    // Il @Controller intercetta la chiamata (/index), setta eventuali parametri e li passa alla view home.jsp
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
	registry.addViewController("/index").setViewName("home");
	
    }
    
    // Registrazione di un Bean ViewResolver che ritorna i file.jsp posizionati sotto il path /WEB-INF/views/
    @Bean
    public ViewResolver viewResolver() {
       InternalResourceViewResolver bean = new InternalResourceViewResolver();

       bean.setViewClass(JstlView.class);
       bean.setPrefix("/WEB-INF/views/");
       bean.setSuffix(".jsp");

       return bean;
    }
    
    // Registrazione risorse statiche
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/");	
	
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public Validator getValidator() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	// TODO Auto-generated method stub
	
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
	// TODO Auto-generated method stub
	
    }

}
