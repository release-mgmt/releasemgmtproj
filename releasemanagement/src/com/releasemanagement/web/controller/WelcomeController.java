package com.releasemanagement.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcomePage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("index");
		return view;
	}
	
}
