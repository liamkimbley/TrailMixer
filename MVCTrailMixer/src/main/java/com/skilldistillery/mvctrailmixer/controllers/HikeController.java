package com.skilldistillery.mvctrailmixer.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.mvctrailmixer.data.TrailsDAO;
import com.skilldistillery.mvctrailmixer.data.UserDAO;
import com.skilldistillery.trailmixer.entities.Profile;
import com.skilldistillery.trailmixer.entities.Trail;
import com.skilldistillery.trailmixer.entities.User;

@Controller
public class HikeController {
	
	@Autowired
	private UserDAO udao;
	
	@Autowired
	private TrailsDAO tdao;

	@RequestMapping(path="addHike.do", method = RequestMethod.GET)
	public ModelAndView viewHikes(HttpSession session) {
		ModelAndView mv = new ModelAndView(); 
		if (session.getAttribute("UserInSession") == null) {
			mv.setViewName("redirect:login.do");
			return mv;
		}
		User userInSession = (User) session.getAttribute(LoginController.USER_IN_SESSION_KEY);
		Profile profile = udao.getProfileById(userInSession.getId());
		List<Trail> trails = udao.getListOfTrailsByProfileId(profile.getId()); 
		mv.addObject("trails", trails); 
		mv.setViewName("hikes/YourHikes");
		return mv;
	}
	
	@RequestMapping(path="addHike.do", method=RequestMethod.POST)
	public ModelAndView addHike(@RequestParam int trailId, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("UserInSession") == null) {
			mv.setViewName("redirect:login.do");
			return mv;
		}
		User userInSession = (User) session.getAttribute(LoginController.USER_IN_SESSION_KEY);
		Profile profile = udao.getProfileById(userInSession.getId());
		List<Trail> trails = udao.addTrailToUser(profile.getId(), trailId); 
		mv.addObject("trails", trails);
		mv.setViewName("hikes/YourHikes");
		return mv;
	}
	
}
