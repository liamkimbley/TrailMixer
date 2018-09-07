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
import com.skilldistillery.trailmixer.entities.Trail;

@Controller 
public class TrailController {
	 @Autowired
	private TrailsDAO dao;
	
	// list of trails and details

	@RequestMapping(path="ListOfTrails.do", method = RequestMethod.GET)
	public ModelAndView getTrailList() {
		ModelAndView mv = new ModelAndView(); 
		List<Trail> trails = dao.getListOfTrails(); 
		mv.addObject("trails", trails); 
		mv.setViewName("trails/ListOfTrails");
		return mv;
	}
						  
	@RequestMapping(path="TrailDetails.do", method = RequestMethod.GET)
	public ModelAndView getDetails(@RequestParam Integer tId) {
		ModelAndView mv = new ModelAndView(); 
		Trail trail = dao.getTrailDetails(tId); 
		Double rating = dao.getTrailRating(tId);
		mv.addObject("rating", rating); 
		mv.addObject("trail", trail); 
		mv.setViewName("trails/TrailDetails");
		return mv;
	}
	
	// sort by 
	
	@RequestMapping(path="ListOfTrailsSorted.do", method = RequestMethod.GET)
	public ModelAndView searchTrailSorted(String sortBy) {
		ModelAndView mv = new ModelAndView(); 
		List<Trail> trails = null; 
		List<Double> trailRatings = null; 
		switch (sortBy) {
		case "difficultyHard":
			trails = dao.sortByDifficultyHard(); 
			break;
		case "difficultyEasy":
			trails = dao.sortByDifficultyEasy(); 
			break;
		case "distanceFar":
			trails = dao.sortByDistanceFar(); 
			break; 
		case "distanceShort":
			trails = dao.sortByDistanceShort(); 
			break; 
		case "altitudeHigh": 
			trails = dao.sortByAltitudeHigh(); 
			break; 
		case "altitudeLow": 
			trails = dao.sortByAltitudeLow(); 
			break; 
		case "rating":
			trailRatings = dao.sortByRating(); 
			break; 
		default:
			trails = dao.getListOfTrails(); 
			break;
		}
		mv.addObject("ratings", trailRatings); 
		mv.addObject("trails", trails); 
		mv.setViewName("trails/ListOfTrails");
		return mv;
	}
	
	// search by 
	
	@RequestMapping(path="ListOfTrailsSearched.do", method = RequestMethod.GET)
	public ModelAndView searchTrail(String searchBy, String search) {
		ModelAndView mv = new ModelAndView(); 
		double d = Double.MAX_VALUE;
		int i = Integer.MAX_VALUE; 
		try {
			d = Double.parseDouble(search); 
			i = Integer.parseInt(search); 
		}
		catch (NumberFormatException nfe) {
		}
		List<Trail> trails = null; 
		switch (searchBy) {
		case "difficulty": 
			trails = dao.searchByDifficulty(i); 
			break; 
		case "distance": 
			trails = dao.searchByDistance(d); 
			break; 
		case "altitude": 
			trails = dao.searchByMaxAltitude(i); 
			break; 
		case "keyword": 
			trails = dao.searchByKeyword(search); 
			break; 
		default:
			trails = dao.getListOfTrails(); 
			break; 
		}
		mv.addObject("trails", trails); 
		mv.setViewName("trails/ListOfTrails");
		return mv;
	}
	
	@RequestMapping(path="navNextTrail.do")
	public ModelAndView navTrailNext(HttpSession session, @RequestParam int trailId) {
		ModelAndView mv = new ModelAndView();
		Trail currentTrail = dao.getTrailDetails(trailId);
		Trail t = dao.getNextTrail(currentTrail);
		session.setAttribute("trail", t);
		mv.setViewName("trails/TrailDetails");
		return mv;
	}
	
	@RequestMapping(path="navPrevTrail.do")
	public ModelAndView navTrailPrev(HttpSession session, @RequestParam int trailId) {
		ModelAndView mv = new ModelAndView();
		Trail currentTrail = dao.getTrailDetails(trailId);
		Trail t = dao.getPrevTrail(currentTrail);
		session.setAttribute("trail", t);
		mv.setViewName("trails/TrailDetails");
		return mv;
	}
	
	private Trail getCurrentTrailFromSession(HttpSession session) {
	    Trail current = (Trail) session.getAttribute("trail");
	    
	    return current;
	  }

}
