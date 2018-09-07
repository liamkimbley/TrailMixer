package com.skilldistillery.trailmixer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class TrailsPopulateTest {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String type;
	private String summary;
	private String difficulty;
	private double stars;
	private String location;
	private String url;
	private String imgSqSmall;
	private String imgSmall;
	private String imgSmallMed;
	private String imgMedium;
	private double length;
	private int ascent;
	private int descent;
	private int high;
	private int low;
	private String latitude;
	private String longitude;
	private String conditionStatus;
	private String coditionDetails;
	private String conditionDate;

	public TrailsPopulateTest() {
	}

	public TrailsPopulateTest(int id, String name, String type, String summary, String difficulty, double stars,
			String location, String url, String imgSqSmall, String imgSmall, String imgSmallMed, String imgMedium,
			double length, int ascent, int descent, int high, int low, String latitude, String longitude,
			String conditionStatus, String coditionDetails, String conditionDate) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.summary = summary;
		this.difficulty = difficulty;
		this.stars = stars;
		this.location = location;
		this.url = url;
		this.imgSqSmall = imgSqSmall;
		this.imgSmall = imgSmall;
		this.imgSmallMed = imgSmallMed;
		this.imgMedium = imgMedium;
		this.length = length;
		this.ascent = ascent;
		this.descent = descent;
		this.high = high;
		this.low = low;
		this.latitude = latitude;
		this.longitude = longitude;
		this.conditionStatus = conditionStatus;
		this.coditionDetails = coditionDetails;
		this.conditionDate = conditionDate;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public double getStars() {
		return stars;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImgSqSmall() {
		return imgSqSmall;
	}

	public void setImgSqSmall(String imgSqSmall) {
		this.imgSqSmall = imgSqSmall;
	}

	public String getImgSmall() {
		return imgSmall;
	}

	public void setImgSmall(String imgSmall) {
		this.imgSmall = imgSmall;
	}

	public String getImgSmallMed() {
		return imgSmallMed;
	}

	public void setImgSmallMed(String imgSmallMed) {
		this.imgSmallMed = imgSmallMed;
	}

	public String getImgMedium() {
		return imgMedium;
	}

	public void setImgMedium(String imgMedium) {
		this.imgMedium = imgMedium;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public int getAscent() {
		return ascent;
	}

	public void setAscent(int ascent) {
		this.ascent = ascent;
	}

	public int getDescent() {
		return descent;
	}

	public void setDescent(int descent) {
		this.descent = descent;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getConditionStatus() {
		return conditionStatus;
	}

	public void setConditionStatus(String conditionStatus) {
		this.conditionStatus = conditionStatus;
	}

	public String getCoditionDetails() {
		return coditionDetails;
	}

	public void setCoditionDetails(String coditionDetails) {
		this.coditionDetails = coditionDetails;
	}

	public String getConditionDate() {
		return conditionDate;
	}

	public void setConditionDate(String conditionDate) {
		this.conditionDate = conditionDate;
	}

}
