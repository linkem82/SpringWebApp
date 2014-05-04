package com.webdev.emilio.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webdev.emilio.models.Member;

@Controller
public class NomineeController {
	
	private final static Logger logger = Logger.getLogger(NomineeController.class);
	
	
	private @Value( "${view_thanks}" )String thanksViewName;
	
	public void setThanksViewName(String name) {
		this.thanksViewName = name;
	}
	
	@RequestMapping(value = "/nominee", method = RequestMethod.GET)
	public Member form() {
		return new Member();
	}
	
	@RequestMapping(value = "/nominee", method = RequestMethod.POST)
	public String processForm(Member member) {
		logger.info("Processing member: " + member);
		return thanksViewName;
	}

}
