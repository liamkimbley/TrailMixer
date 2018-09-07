package com.skilldistillery.trailmixer.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.trailmixer.entities.Profile;

class ProfileTest {
	private EntityManagerFactory emf; 
	private EntityManager em; 
	private Profile prof; 

	@BeforeEach
	public void setUp() {
		emf = Persistence.createEntityManagerFactory("TrailMixer");
		em = emf.createEntityManager();
		prof = em.find(Profile.class, 1); 
	}

	@AfterEach()
	public void tearDown() {
		em.close();
		emf.close();
	}

	@Test
	public void test_one_profile_to_one_user() {
		assertEquals(1, prof.getUser().getId()); 
	}

	@Test
	public void test_one_profile_to_many_preferences() {
		assertEquals(10000, prof.getPreferences().get(0).getAltitude()); 
	}

	@Test
	public void test_one_profile_to_one_address() {
		assertEquals("Colorado", prof.getAddress().getState()); 
	}

	@Test
	public void test_one_profile_to_many_trails() {
		assertEquals("test trail", prof.getTrails().get(0).getName()); 
	}

	@Test
	public void test_one_profile_to_many_reasons() {
		assertEquals("Fun", prof.getReasons().get(0).getName()); 
	}
	
	@Test
	public void test_profile_with_preferences_list() {
		Profile p = em.find(Profile.class, 1);
		String query = "SELECT p FROM Profile p JOIN FETCH p.preferences WHERE p.id = :id";
		Profile prof = em.createQuery(query, Profile.class).setParameter("id", 1).getSingleResult(); 
		assertNotEquals(0, prof.getPreferences().size());
	}

}
