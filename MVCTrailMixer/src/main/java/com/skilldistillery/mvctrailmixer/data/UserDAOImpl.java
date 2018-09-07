package com.skilldistillery.mvctrailmixer.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.skilldistillery.trailmixer.entities.Address;
import com.skilldistillery.trailmixer.entities.Area;
import com.skilldistillery.trailmixer.entities.Difficulty;
import com.skilldistillery.trailmixer.entities.Preference;
import com.skilldistillery.trailmixer.entities.Profile;
import com.skilldistillery.trailmixer.entities.Trail;
import com.skilldistillery.trailmixer.entities.User;

@Transactional
@Component
public class UserDAOImpl implements UserDAO {

	public static final String userQuery = "Select u from User u";

	private Map<String, User> users;

	@PersistenceContext
	private EntityManager em;

	@Override
	public Map<String, User> getUsers() {
		String query = "Select u from User u";
		List<User> userList = em.createQuery(query).getResultList();
		users = new HashMap<>();
		for (User user : userList) {
			users.put(user.getUsername(), user);
		}
		return users;
	}

	@Override
	public User getUserByUserName(String userName) {
		String query = "Select u from User u where u.username = :name";
		User u = null;
		try {
			List<User> users = em.createQuery(query, User.class).setParameter("name", userName).getResultList();
			if (users != null && users.size() > 0) {
				u = users.get(0);
			}

		} catch (NoResultException e) {
		}

		return u;
	}

	@Override
	public User findUserById(int userId) {
		User u = users.get(userId);
		return u;
	}

	@Override
	public User updateUser(User user) {
		User updatedUser = em.find(User.class, user.getId());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setUsername(user.getUsername());
		updatedUser.setActiveUser(1);
		return updatedUser;
	}

	/*
	 * instead of deleting the user, i am setting the "active status" to 0. when the
	 * user logs in, we will check to see if it is an active user before we direct
	 * them to the account page
	 */
	@Override
	public boolean deleteUser(int userId) {
		User u = em.find(User.class, userId);

		u.setActiveUser(0);

		return (u.getActiveUser() == 0);
	}

	@Override
	public User addUser(User user, String firstName, String lastName, int age) {
		Profile profile = new Profile();
		Address addr = em.find(Address.class, 1);
		user.setActiveUser(1);
		profile.setFirstName(firstName);
		profile.setLastName(lastName);
		profile.setAge(age);
		profile.setUser(user);
		profile.setAddress(addr);
		
		em.persist(user);
		em.persist(profile);
		em.flush();

		return user;

	}

	@Override
	public Profile addProfile(Profile profile) {

		em.persist(profile);
		em.flush();

		return profile;

	}

	@Override
	public boolean duplicateUsername(String username) {
		boolean duplicate = true;
		List<User> allUsers = em.createQuery(userQuery, User.class).getResultList();
		for (User user : allUsers) {
			if (user.getUsername().equalsIgnoreCase(username)) {
				duplicate = false;
			}
		}
		return duplicate;
	}

	@Override
	public Profile findProfileById(int profileId) {

		Profile prof;
		try {
			String query = "SELECT p FROM Profile p JOIN FETCH p.preferences WHERE p.user.id = :id";

			prof = em.createQuery(query, Profile.class).setParameter("id", profileId).getResultList().get(0);
		} catch (Exception e) {
			prof = em.createQuery("SELECT p FROM Profile p WHERE p.user.id = :id", Profile.class)
					.setParameter("id", profileId).getResultList().get(0);
		}
		return prof;
	}

	@Override
	public Profile updateProfile(int id, String firstName, String lastName, int age, String image, String gender, String bio) {
		Profile updatedProf = em.find(Profile.class, id);
		updatedProf.setFirstName(firstName);
		updatedProf.setLastName(lastName);
		updatedProf.setAge(age);
		updatedProf.setImage(image);
		updatedProf.setGender(gender);
		updatedProf.setBio(bio);
//		updatedProf.setAddress(findAddress(address));
		return updatedProf;
	}

	@Override
	public Preference updatePreference(Preference pref) {
		Preference updatedPref = em.find(Preference.class, pref.getId());
		updatedPref.setDifficulty(pref.getDifficulty());
		updatedPref.setDistance(pref.getDistance());
		updatedPref.setArea(pref.getArea());
		updatedPref.setAltitude(pref.getAltitude());
		return updatedPref;
	}

	@Override
	public Preference updatePreference(int id, String difficulty, String area, double distance, int altitude) {
		Preference updatedPref = em.find(Preference.class, id);
		updatedPref.setDifficulty(findDifficulty(difficulty));
		updatedPref.setDistance(distance);
		updatedPref.setArea(findArea(area));
		updatedPref.setAltitude(altitude);
		return updatedPref;
	}
	
	@Override
	public Difficulty findDifficulty(String name) {
		String query = "SELECT d FROM Difficulty d WHERE d.name = :name";
		List<Difficulty> diffs = em.createQuery(query, Difficulty.class).setParameter("name", name).getResultList(); 
		return diffs.get(0); 
	}
	
	@Override
	public Area findArea(String city) {
		String query = "SELECT a FROM Area a WHERE a.city = :city";
		List<Area> area = em.createQuery(query, Area.class).setParameter("city", city).getResultList(); 
		return area.get(0); 
	}

	@Override
	public List<Preference> getPreferencesByProfileId(int id) {
		String query = "SELECT pref FROM Preference pref WHERE pref.profile.id = :id";
		List<Preference> prefs = em.createQuery(query, Preference.class).setParameter("id", id).getResultList();
		return prefs;
	}

	public User getUserInformation(int id) {
		String query = "SELECT u FROM User u WHERE u.id = :id";
		User user = em.createQuery(query, User.class).setParameter("id", id).getSingleResult();
		return user;
	}

	public Profile getProfileById(int id) {
		String query = "SELECT p FROM Profile p JOIN FETCH p.trails WHERE p.id = :id";
		List<Profile> results = em.createQuery(query, Profile.class).setParameter("id", id).getResultList();
		if (results.size() > 0) {
			return results.get(0);
		}
		else {
			Profile p = em.find(Profile.class, id);
			p.setTrails(new ArrayList<>());
			return p;
		}
	}
	
	public List<Trail> addTrailToUser(int profileId, int trailId) {
		String query = "SELECT p FROM Profile p JOIN FETCH p.trails WHERE p.id = :id";
		List<Profile> profiles = em.createQuery(query, Profile.class).setParameter("id", profileId).getResultList();
		Trail t = em.find(Trail.class, trailId); 
		if (profiles.size() > 0) {
			Profile profile = profiles.get(0);
			profile.addTrail(t);
			return profile.getTrails();
		}
		else {
			Profile p = em.find(Profile.class, profileId);
			p.setTrails(new ArrayList<>());
			p.addTrail(t);
			return p.getTrails(); 
		}
	}
	
	@Override
	public Profile addPreference(int profileId, String difficulty, String area, double distance, int altitude) {
		Profile profile = em.find(Profile.class, profileId);
		Preference preference = new Preference();
		Area areaA = new Area();
		Difficulty diff = new Difficulty();
		diff.setName(difficulty);
		areaA.setCity(area);
		areaA.setState("Colorado");
		preference.setAltitude(altitude);
		preference.setDistance(distance);
		preference.setArea(areaA);
		preference.setProfile(profile);
		profile.addPreference(preference);
		em.persist(preference);
		em.flush();
		return profile;
	}
	
	public List<Trail> getListOfTrailsByProfileId(int profileId) {
		String query = "SELECT p FROM Profile p JOIN FETCH p.trails WHERE p.id = :id";
		Profile prof = em.createQuery(query, Profile.class).setParameter("id", profileId).getResultList().get(0);
		return prof.getTrails(); 
	}
}