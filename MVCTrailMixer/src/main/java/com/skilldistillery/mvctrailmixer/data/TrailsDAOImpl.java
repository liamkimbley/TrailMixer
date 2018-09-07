package com.skilldistillery.mvctrailmixer.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.skilldistillery.trailmixer.entities.Trail;

@Transactional
@Component
public class TrailsDAOImpl implements TrailsDAO{
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrailMixer");
	private EntityManager em = emf.createEntityManager();

	@Override
	public List<Trail> getListOfTrails() {
		String query = "SELECT t FROM Trail t"; 
		List<Trail> trails = em.createQuery(query, Trail.class).getResultList(); 
		return trails;
	}
	
	@Override
	public Trail getTrailDetails(int id) {
		String query = "SELECT t FROM Trail t JOIN FETCH t.address WHERE t.id = :id"; 
		Trail tr = em.createQuery(query, Trail.class).setParameter("id", id).getSingleResult(); 
		return tr; 
	}
	
	@Override
	public Double getTrailRating(int id) {
		String query = "SELECT AVG(pt.rating) FROM ProfileTrail pt WHERE pt.trail.id = :tid";
		Double rating = em.createQuery(query, Double.class).setParameter("tid", id).getSingleResult();
		return rating;
	}

	// "search by" methods
	
	@Override
	public List<Trail> searchByDifficulty(int difficulty) {
		String query = "SELECT t FROM Trail t WHERE t.difficulty.id = :difficulty";
		List<Trail> trails = em.createQuery(query, Trail.class).setParameter("difficulty", difficulty).getResultList();
		return trails;
	}
	
	@Override
	public List<Trail> searchByDistance(double distance) {
		String query = "SELECT t FROM Trail t WHERE t.distance <= :distance ORDER BY t.distance DESC";
		List<Trail> trails = em.createQuery(query, Trail.class).setParameter("distance", distance).getResultList();
		return trails;
	}

	@Override
	public List<Trail> searchByMaxAltitude(int altitude) {
		String query = "SELECT t FROM Trail t WHERE t.altitude <= :altitude ORDER BY t.altitude DESC";
		List<Trail> trails = em.createQuery(query, Trail.class).setParameter("altitude", altitude).getResultList();
		return trails;
	}

	@Override
	public List<Trail> searchByRating(int rating) {
		String query = "SELECT t FROM Trail t JOIN ProfileTrail pt ON t.id = pt.trail.id WHERE pt.rating <= :rating";
		List<Trail> trails = em.createQuery(query, Trail.class).setParameter("rating", rating).getResultList();
		return trails;
	}

	@Override
	public List<Trail> searchByKeyword(String keyword) {
		String query = "SELECT t FROM Trail t WHERE t.name LIKE :keyword";
		List<Trail> trails = em.createQuery(query, Trail.class).setParameter("keyword", "%" + keyword + "%").getResultList();
		return trails;
	}
	
	// "sort by" methods 
	
	@Override
	public List<Trail> sortByDifficultyHard() {
		String query = "SELECT t FROM Trail t ORDER BY t.difficulty DESC";
		List<Trail> trails = em.createQuery(query, Trail.class).getResultList();
		return trails;
	}
	
	@Override
	public List<Trail> sortByDifficultyEasy() {
		String query = "SELECT t FROM Trail t ORDER BY t.difficulty ASC";
		List<Trail> trails = em.createQuery(query, Trail.class).getResultList();
		return trails;
	}

	@Override
	public List<Trail> sortByDistanceFar() {
		String query = "SELECT t FROM Trail t ORDER BY t.distance DESC";
		List<Trail> trails = em.createQuery(query, Trail.class).getResultList();
		return trails;
	}
	
	@Override
	public List<Trail> sortByDistanceShort() {
		String query = "SELECT t FROM Trail t ORDER BY t.distance ASC";
		List<Trail> trails = em.createQuery(query, Trail.class).getResultList();
		return trails;
	}
	
	@Override
	public List<Trail> sortByAltitudeHigh() {
		String query = "SELECT t FROM Trail t ORDER BY t.altitude DESC";
		List<Trail> trails = em.createQuery(query, Trail.class).getResultList();
		return trails;
	}
	
	@Override
	public List<Trail> sortByAltitudeLow() {
		String query = "SELECT t FROM Trail t ORDER BY t.altitude ASC";
		List<Trail> trails = em.createQuery(query, Trail.class).getResultList();
		return trails;
	}
	
	@Override
	public List<Double> sortByRating() {
		String query = "SELECT AVG(pt.rating) FROM ProfileTrail pt ORDER BY pt.rating DESC";
		List<Double> trailRatings = em.createQuery(query, Double.class).getResultList();
		return trailRatings;
	}

	@Override
	public Trail getNextTrail(Trail current) {
		int index = -1;
	    Trail t = null;
	    List<Trail> trails = getListOfTrails();
	    for (int i = 0; i < trails.size(); i++) {
	      Trail trail = trails.get(i);
	      if (trail.getName().equalsIgnoreCase(current.getName())) {
	        index = i;
	        break;
	      }
	    }
	    index++;
	    if (index == trails.size()) {
	      index = 0;
	    }

	    t = trails.get(index);
	    return t;
		
	}

	@Override
	public Trail getPrevTrail(Trail current) {
		int index = -1;
	    Trail t = null;
	    List<Trail> trails = getListOfTrails();
	    for (int i = 0; i < trails.size(); i++) {
	      Trail trail = trails.get(i);
	      if (trail.getName().equalsIgnoreCase(current.getName())) {
	        index = i;
	        break;
	      }
	    }
	    index--;
	    if (index == -1) {
	      index = trails.size() - 1;
	    }

	    t = trails.get(index);
	    return t;
				
	}

}
