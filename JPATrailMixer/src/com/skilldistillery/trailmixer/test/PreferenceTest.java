package com.skilldistillery.trailmixer.test;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.trailmixer.entities.Preference;

class PreferenceTest {
	private EntityManagerFactory emf; 
	private EntityManager em; 
	private Preference pref; 

	@BeforeEach
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("TrailMixer");
		em = emf.createEntityManager();
		pref = em.find(Preference.class, 1); 
	}

	@AfterEach()
	public void tearDown() {
		em.close();
		emf.close();
	}

	@Test
	public void test_preference_with_id() {
		assertEquals(1, pref.getId()); 
	}

	@Test
	public void test_many_preferences_to_one_difficulty() {
		assertEquals("Easy", pref.getDifficulty().getName()); 
	}

	@Test
	public void test_many_preferences_to_one_profile() {
		assertEquals("John", pref.getProfile().getFirstName()); 
	}

	@Test
	public void test_many_preferences_to_one_area() {
		assertEquals("Denver", pref.getArea().getCity()); 
	}

}
