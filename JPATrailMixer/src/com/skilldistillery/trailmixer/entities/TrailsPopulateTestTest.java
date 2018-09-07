package com.skilldistillery.trailmixer.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embeddable;

@Embeddable
class TrailsPopulateTestTest {

	private List<TrailsPopulateTest> trails = new ArrayList<>();
	private int success;

	public TrailsPopulateTestTest() {
	}

	public TrailsPopulateTestTest(List<TrailsPopulateTest> trails, int success) {
		super();
		this.trails = trails;
		this.success = success;
	}

	public List<TrailsPopulateTest> getTrails() {
		return trails;
	}

	public void setTrails(List<TrailsPopulateTest> trails) {
		this.trails = trails;
	}

	public int getSuccess() {
		return success;
	}

	public void setSuccess(int success) {
		this.success = success;
	}

}
