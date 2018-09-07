package com.skilldistillery.mvctrailmixer.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.mvctrailmixer.data.TrailsDAO;
import com.skilldistillery.mvctrailmixer.data.UserDAO;
import com.skilldistillery.trailmixer.entities.Address;
import com.skilldistillery.trailmixer.entities.Preference;
import com.skilldistillery.trailmixer.entities.Profile;
import com.skilldistillery.trailmixer.entities.Trail;
import com.skilldistillery.trailmixer.entities.User;

@Controller
public class MatchesController {
	
	@Autowired
	private TrailsDAO tdao;
	
	@Autowired
	private UserDAO udao;
	
	public static final String USER_IN_SESSION_KEY = "UserInSession";

	@RequestMapping(path="TrailMatches.do", method=RequestMethod.GET)
	public ModelAndView getMatches(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (session.getAttribute("UserInSession") == null) {
			mv.setViewName("redirect:login.do");
			return mv;
		}
			User userInSession = (User) session.getAttribute(LoginController.USER_IN_SESSION_KEY);
//			Profile profile = udao.findProfileById(userInSession.getId());
			List<Preference> preferences = udao.getPreferencesByProfileId(userInSession.getId());
			List<Trail> trails = tdao.getListOfTrails();
			List<Trail> preferredTrails = new ArrayList<>();
			if (!preferences.isEmpty()) {
				for (Trail trail : trails) {
					Address addr = tdao.getTrailDetails(trail.getId()).getAddress();
					if (trail.getAddress().getCity()
							.equalsIgnoreCase(preferences.get(0).getArea().getCity())) {
						if (trail.getDifficulty().getId() <= preferences.get(0).getDifficulty().getId()) {
							if (trail.getAltitude() <= preferences.get(0).getAltitude()) {
								if (trail.getDistance() <= preferences.get(0).getDistance()) {
									preferredTrails.add(trail);
								}
							}
						}
					}
				} 
				mv.addObject("trails", preferredTrails);
				mv.setViewName("hikes/matches");
				return mv;
			}
		else {
			mv.setViewName("redirect:ListOfTrails.do");
			return mv;
		}
	}
	
}
