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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Trail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String description;
	private int altitude;

	@Column(name = "img_url")
	private String image;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "difficulty_id")
	private Difficulty difficulty;

	private double distance;

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToMany(mappedBy="trails")
	private List<Profile> profiles;

	@OneToMany(mappedBy="trail")
	private List<ProfileTrail> pts;
	//	end of fields

	public Trail() {
	}

	public Trail(String name, String description, int altitude, String image, Difficulty difficulty, double distance,
			Address address) {
		this.name = name;
		this.description = description;
		this.altitude = altitude;
		this.image = image;
		this.difficulty = difficulty;
		this.distance = distance;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(List<Profile> profiles) {
		this.profiles = profiles;
	}

	public List<ProfileTrail> getPts() {
		return pts;
	}

	public void setPts(List<ProfileTrail> pts) {
		this.pts = pts;
	}

	public void addProfile(Profile profile) {
		if (profiles == null) {
			profiles = new ArrayList<>();
		}
		if (!profiles.contains(profile)) {
			profiles.add(profile);
			profile.addTrail(this);
		}
	}

	public void removeProfile(Profile profile) {
		if (profiles != null && profiles.contains(profile)) {
			profiles.remove(profile);
			profile.removeTrail(this);
		}
	}

	public void addPt(ProfileTrail pt) {
		if (pts == null) {
			pts = new ArrayList<>();
		}
		if (!pts.contains(pt)) {
			pts.add(pt);
			if (pt.getTrail() != null) {
				pt.getTrail().getPts().remove(pt);
			}
			pt.setTrail(this);
		}
	}

	public void removePt(ProfileTrail pt) {
		pt.setTrail(null);
		if (pts != null) {
			pts.remove(pt);
		}
	}

	@Override
	public String toString() {
		return "Trail [name=" + name + ", description=" + description + ", altitude=" + altitude + ", image=" + image
				+ ", distance=" + distance + "]";
	}


}
