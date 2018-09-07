package com.skilldistillery.mvctrailmixer.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.mvctrailmixer.data.UserDAO;
import com.skilldistillery.trailmixer.entities.Profile;
import com.skilldistillery.trailmixer.entities.User;

@Controller
public class LoginController {
	
	@Autowired
	private UserDAO dao;
	
	public static final String USER_IN_SESSION_KEY = "UserInSession";

	@RequestMapping(path="login.do", method = RequestMethod.GET)
	public ModelAndView login(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		User userInSession = (User) session.getAttribute(USER_IN_SESSION_KEY);
		
		// If a user is logged in and requests login.do they will be redirected to their profile page
		if(userInSession != null) {
			
			Profile profile = dao.findProfileById(userInSession.getId());
			mv.addObject("profile", profile);
			mv.setViewName("trails/profile");
			
			return mv;
		}
		
		mv.addObject("user", new User());
		mv.setViewName("trails/login");
		return mv;
	}
	
	@RequestMapping(path="login.do", method = RequestMethod.POST)
	public ModelAndView loginUser(User inputUser, Errors errors, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		User daoUser = dao.getUserByUserName(inputUser.getUsername());
		if(daoUser == null) {
			// show them the login page
			mv.setViewName("trails/login"); 
			errors.rejectValue("username", "error.username", "Invalid Username");
			return mv;
		}
		else if (daoUser.getActiveUser() == 0){
//			if the user is set to inactive, don't take them to the login page.
//			instead, we need to ask them to set the account back to active
			mv.setViewName("trails/login");
			errors.rejectValue("username", "error.username", "Invalid Username");
			return mv;
		}
		else if (daoUser.getPassword().equals(inputUser.getPassword())){
			// load the User object into session, and redirect to the account page, account.do
			session.setAttribute(USER_IN_SESSION_KEY, daoUser);
			Profile profile = dao.findProfileById(daoUser.getId());
			mv.addObject("profile", profile);
			mv.setViewName("trails/profile");
			return mv;
		}
		else {
			mv.setViewName("trails/login");
			errors.rejectValue("password", "error.password", "Invalid Password");
			return mv;
		}
	}
	
	@RequestMapping(path="logout.do")
	public String logout(HttpSession session) {
		
		// remove user from session
		session.removeAttribute(USER_IN_SESSION_KEY);
		
		return "redirect:login.do";
	}
	
	@RequestMapping(path="SignUp.do", method = RequestMethod.GET)
	public ModelAndView createAccount(HttpSession session) {
	ModelAndView mv = new ModelAndView();
	mv.addObject("user", new User());
	mv.setViewName("trails/SignUp");
	return mv;
	}
	
	@RequestMapping(path="SignUp.do", method = RequestMethod.POST)
	public String newUser(@ModelAttribute("user") @Valid User newUser, BindingResult result, 
			Model model, RedirectAttributes redir,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("age") int age)
			{
		
			if(result.hasErrors()) {
				model.addAttribute("user", new User());
				return "redirect:login.do";	
			}
				
		User inputedUser = dao.addUser(newUser, firstName, lastName, age);
		
		Profile profile = dao.findProfileById(newUser.getId());
		
		
		if (inputedUser != null) {
			redir.addFlashAttribute("accountCreatedSuccess", true);
		}
		
		return "redirect:login.do";
	}
	
}
