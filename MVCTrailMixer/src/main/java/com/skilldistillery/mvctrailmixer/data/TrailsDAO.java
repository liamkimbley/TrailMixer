package com.skilldistillery.mvctrailmixer.data;

import java.util.List;

import com.skilldistillery.trailmixer.entities.ProfileTrail;
import com.skilldistillery.trailmixer.entities.Trail;

public interface TrailsDAO {
	public List<Trail> getListOfTrails(); 
	public Trail getTrailDetails(int id); 
	public List<Trail> searchByDifficulty(int difficulty); 
	public List<Trail> searchByDistance(double distance); 
	public List<Trail> searchByMaxAltitude(int altitude); 
	public List<Trail> searchByRating(int rating); 
	public List<Trail> searchByKeyword(String keyword); 
	public List<Trail> sortByDifficultyHard(); 
	public List<Trail> sortByDifficultyEasy(); 
	public List<Trail> sortByDistanceFar(); 
	public List<Trail> sortByDistanceShort(); 
	public List<Trail> sortByAltitudeHigh(); 
	public List<Trail> sortByAltitudeLow(); 
	public List<Double> sortByRating();
	public Double getTrailRating(int id); 
	public Trail getNextTrail(Trail trail);
	public Trail getPrevTrail(Trail trail);
}
