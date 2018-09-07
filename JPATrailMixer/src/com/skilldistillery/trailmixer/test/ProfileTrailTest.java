package com.skilldistillery.trailmixer.test;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.trailmixer.entities.Profile;
import com.skilldistillery.trailmixer.entities.Trail;

class ProfileTrailTest {
	private EntityManagerFactory emf; 
	private EntityManager em; 
	private Trail tr; 
	private Profile prof; 

	@BeforeEach
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("TrailMixer");
		em = emf.createEntityManager();
	}

	@AfterEach()
	public void tearDown() {
		em.close();
		emf.close();
	}

	@Test
	public void test_profiletrail_to_profile_on_rating() {
		prof = em.find(Profile.class, 1); 
		assertEquals(Double.valueOf(4.0), prof.getPts().get(0).getRating()); 
	}

	@Test
	public void test_profiletrail_to_trail_on_rating() {
		tr = em.find(Trail.class, 1); 
		assertEquals(Double.valueOf(4.0), tr.getPts().get(0).getRating()); 
	}

}
