package com.springmvc.javaconfig.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebAppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
	
	////// VERSIONE IBRIDA CON IL FILE XML "servlet-context.xml" MA SENZA il file "web.xml" ////////
//	XmlWebApplicationContext context = new XmlWebApplicationContext();
//	context.setConfigLocation("/WEB-INF/spring/appServlet/servlet-context.xml");
	
	// Registra l'istanza della servlet data con questo ServletContext sotto la servlet chiamata "dispatcher".
//	ServletRegistration.Dynamic dispatcher = servletContext
//	          .addServlet("dispatcher", new DispatcherServlet(context));

	// La servlet viene registrata a un pattern URL (in questo caso il root pattern "/") 
	// che specifica quali richieste HTTP verranno gestite da questa.
//	dispatcher.setLoadOnStartup(1);
//	dispatcher.addMapping("/");
	
	
	////// VERSIONE CONFIGURATA INTERAMENTE IN JAVA SENZA FILE.XML ////////
	AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	context.setConfigLocation("com.springmvc.javaconfig.config"); // aggiungiamo al servletContext la classe di Configurazione per quest'ultimo
	
	//context.register(WebConfig.class);
	//context.scan("com.springmvc.javaconfig");
	
	servletContext.addListener(new ContextLoaderListener(context)); //registriamo al servletContext il contesto creato
	
	ServletRegistration.Dynamic dispatcher = servletContext
		  .addServlet("dispatcher", new DispatcherServlet(context));

	dispatcher.setLoadOnStartup(1);
	dispatcher.addMapping("/");
	
    }

}
