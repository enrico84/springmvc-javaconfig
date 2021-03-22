package com.springmvc.javaconfig.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Aprire il browser al path http://localhost:8081/javaconfig/index
	 */
	@GetMapping(value = "/index")
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		String message1 = "Ciao, Questo è un esempio di applicazione SpringMVC";
		String message2 = " con configurazione interamente in Java";
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message1", message1);
		model.addAttribute("message2", message2);
		
		return "home";
	}
	
}
