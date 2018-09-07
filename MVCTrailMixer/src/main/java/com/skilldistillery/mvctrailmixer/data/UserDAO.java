package com.skilldistillery.mvctrailmixer.data;

import java.util.List;
import java.util.Map;

import com.skilldistillery.trailmixer.entities.Area;
import com.skilldistillery.trailmixer.entities.Difficulty;
import com.skilldistillery.trailmixer.entities.Preference;
import com.skilldistillery.trailmixer.entities.Profile;
import com.skilldistillery.trailmixer.entities.Trail;
import com.skilldistillery.trailmixer.entities.User;

public interface UserDAO {
	  public User getUserByUserName(String userName);
	  public User findUserById(int userId);
	  public User updateUser(User user);
	  public boolean deleteUser(int userId);
	  public Profile addProfile(Profile profile);
	  public boolean duplicateUsername(String username);
	  public Map<String, User> getUsers();
	  public Profile findProfileById(int profileId);
	  public Profile updateProfile(int id, String firstName, String lastName, int age, String image, String gender, String bio);
	  public Preference updatePreference(Preference pref); 
	  public Preference updatePreference(int id, String difficulty, String area, double distance, int altitude);
	  public Difficulty findDifficulty(String name); 
	  public Area findArea(String city); 
	  public List<Preference> getPreferencesByProfileId(int profileId); 
	  public User getUserInformation(int id);
	  public Profile getProfileById(int id);
	  public User addUser(User user, String firstName, String lastName, int age); 
	  public List<Trail> addTrailToUser(int profileId, int trailId);
	  public Profile addPreference(int profileId, String difficulty, String area, double distance, int altitude); 
	  public List<Trail> getListOfTrailsByProfileId(int id);
}
