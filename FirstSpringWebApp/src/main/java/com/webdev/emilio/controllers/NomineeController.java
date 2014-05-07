package com.webdev.emilio.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String processForm(Member member, RedirectAttributes redirectAttrs) {
		logger.info("Processing member: " + member);
		redirectAttrs.addFlashAttribute("passedMember", member);
		return "redirect:" + thanksViewName;
	}	
	
	@RequestMapping(value = "/nominee/thanks", method = RequestMethod.GET)
	public String afterRedirect(@ModelAttribute("passedMember") Member passedMember) {
		return thanksViewName;
	}
	
}
