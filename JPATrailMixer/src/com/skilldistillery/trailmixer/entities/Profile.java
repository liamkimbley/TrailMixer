package com.skilldistillery.trailmixer.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@NotNull
	@Column(name = "first_name")
	private String firstName;
	
	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	private int age;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "img_url")
	private String image;

	private String bio;

	private String gender;


	@OneToMany(mappedBy = "profile")
	private List<Preference> preferences;

	@OneToMany(mappedBy="profile")
	private List<ProfileTrail> pts;

	@ManyToMany(mappedBy="profiles")
	private List<Reason> reasons;

	@ManyToMany
	@JoinTable()
	private List<Profile> friends;

	@ManyToMany
	@JoinTable(name="profile_trail",
	joinColumns=@JoinColumn(name="profile_id"),
	inverseJoinColumns=@JoinColumn(name="trail_id"))
	private List<Trail> trails;
	// end of fields

	public Profile() {
	}

	public Profile(User user, String firstName, String lastName, int age, Address address, String image, String bio) {
		this.user = user;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.address = address;
		this.image = image;
		this.bio = bio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}

	public List<ProfileTrail> getPts() {
		return pts;
	}

	public void setPts(List<ProfileTrail> pts) {
		this.pts = pts;
	}

	public List<Profile> getFriends() {
		return friends;
	}

	public void setFriends(List<Profile> friends) {
		this.friends = friends;
	}

	public List<Trail> getTrails() {
		return trails;
	}

	public void setTrails(List<Trail> trails) {
		this.trails = trails;
	}

	public List<Reason> getReasons() {
		return reasons;
	}

	public void setReasons(List<Reason> reasons) {
		this.reasons = reasons;
	}

	public void addPreference(Preference pref) {
		if (preferences == null) {
			preferences = new ArrayList<>();
		}
		if (!preferences.contains(pref)) {
			preferences.add(pref);
			if (pref.getProfile() != null) {
				pref.getProfile().getPreferences().remove(pref);
			}
			pref.setProfile(this);
		}
	}

	public void removePreference(Preference pref) {
		pref.setProfile(null);
		if (preferences != null) {
			preferences.remove(pref);
		}
	}

	public void addPt(ProfileTrail pt) {
		if (pts == null) {
			pts = new ArrayList<>();
		}
		if (!pts.contains(pt)) {
			pts.add(pt);
			if (pt.getProfile() != null) {
				pt.getProfile().getPts().remove(pt);
			}
			pt.setProfile(this);
		}
	}

	public void removePt(ProfileTrail pt) {
		pt.setProfile(null);
		if (pts != null) {
			pts.remove(pt);
		}
	}

	public void addTrail(Trail trail) {
		if (trails == null) {
			trails = new ArrayList<>();
		}
		if (!trails.contains(trail)) {
			trails.add(trail); 
			trail.addProfile(this);
		}
	}

	public void removeTrail(Trail trail) {
		if (trails != null && trails.contains(trail)) {
			trails.remove(trail);
			trail.removeProfile(this);
		}
	}

	public void addReason(Reason reason) {
		if (reasons == null) {
			reasons = new ArrayList<>();
		}
		if (!reasons.contains(reason)) {
			reasons.add(reason);
			reason.addProfile(this);
		}
	}

	public void removeReason(Reason reason) {
		if (reasons != null && reasons.contains(reason)) {
			reasons.remove(reason);
			reason.removeProfile(this);
		}
	}

	@Override
	public String toString() {
		return "Profile [user=" + user + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", image=" + image + ", bio=" + bio + ", gender=" + gender + "]";
	}


}
