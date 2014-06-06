package com.webdev.emilio.controllers;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webdev.emilio.models.Account;
import com.webdev.emilio.models.AccountForm;
import com.webdev.emilio.services.AccountService;

@Controller
@RequestMapping("/users")
public class FormController {
	
	private static final Logger logger = LoggerFactory.getLogger(FormController.class);
	private static final String REG_VIEW = "users/registration";
	private static final String REG_OK_VIEW = "users/registration_ok";
	@Inject private AccountService accountService;
	@Inject @Qualifier("authenticationManager") private AuthenticationManager authManager;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields(new String[]{"username", "password", "confirmPassword", "confirmEmail", "email", 
				"firstName", "lastName", "marketingOk", "acceptTerms"});
	}
	
	/**
	 * It converts the global error password mismatch into an error on the password field.
	 * @param result
	 */
	private void convertPasswordError(BindingResult result) {
		for(ObjectError error: result.getGlobalErrors()) {
			String message = error.getDefaultMessage();
			if(message.equals("account.password.mismatch.message")) 
				if(!result.hasFieldErrors("password"))
					result.rejectValue("password", "error.mismatch");			
		}
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String getForm(Model model) {
		model.addAttribute("account", new AccountForm());		
		return this.REG_VIEW;	
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String postRegistration(@ModelAttribute("account") @Valid AccountForm form, BindingResult result) {
		logger.info("User data:" + form.toString());
		convertPasswordError(result);
		Account account = formToAccount(form);
		this.accountService.registerAccount(account, form.getPassword(), result);
		/* automatic login after registration */
		Authentication authRequest = new UsernamePasswordAuthenticationToken(account.getUsername(), form.getPassword());
		Authentication authResponse = authManager.authenticate(authRequest);
		SecurityContextHolder.getContext().setAuthentication(authResponse);
		return result.hasErrors() ? REG_VIEW : REG_OK_VIEW;	
	}
	
	@RequestMapping(value="/users/registration_ok", method = RequestMethod.GET)
	public String postRedirect() {		
		return REG_OK_VIEW;
	}
	
	private Account formToAccount(AccountForm form) {
		Account account = new Account();
		account.setUsername(form.getUsername());
		account.setFirstName(form.getFirstName());
		account.setLastName(form.getLastName());
		account.setEmail(form.getEmail());
		account.setAcceptTerm(form.isAcceptTerms());
		account.setMarketingOk(form.isMarketingOk());
		account.setEnabled(true);
		return account;
	}
}
