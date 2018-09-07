package com.skilldistillery.trailmixer.entities;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

@Transactional
@Embeddable
class TestAPI {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("TrailMixer");
	private static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) throws Exception {
		Response response;
		
		String json = "";

		try {

			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder().url(
					"https://www.hikingproject.com/data/get-trails?lat=39.7392&lon=-104.9903&maxDistance=50&key=200347795-ecda7b9eb2dfd76c87e6ec49c60f4b2c")
					.get().addHeader("Cache-Control", "no-cache")
					.addHeader("Postman-Token", "39e09bb9-29f4-4370-840a-52c5ef3d323e").build();

			response = client.newCall(request).execute();
			
			json = response.body().string();

		} catch (Exception e) {

			if (e.getCause() != null) {
				throw new Exception("Account Aggregation Failed: " + e.getCause());
			} else {
				throw new Exception("Account Aggregation Failed: " + e.getMessage());
			}
		}
		
		System.out.println("response body:[" + json + "]");
		
		Gson gson = new Gson();
		
		TrailsPopulateTestTest tp = gson.fromJson(json, TrailsPopulateTestTest.class);
		System.out.println("tp:[" + tp + "]");
		
		List<TrailsPopulateTest> trails = (List<TrailsPopulateTest>)tp.getTrails();
		
		if (trails != null) {
			int id = 50;
			for (int i = 0 ; i < trails.size(); id++, i++) {
				int diff = 1;
				if (trails.get(i).getDifficulty().equalsIgnoreCase("blue")) {
					diff = 3;
				}
				if (trails.get(i).getDifficulty().equalsIgnoreCase("blueBlack")) {
					diff = 4;
				}
				if (trails.get(i).getDifficulty().equalsIgnoreCase("black")) {
					diff = 5;
				}
				Difficulty difficulty = em.find(Difficulty.class, diff);
				Address na = new Address();
				Trail trail = new Trail();
				na.setCity("Denver");
				na.setState("Colorado");
				na.setLatitude(trails.get(i).getLatitude());
				na.setLongitude(trails.get(i).getLongitude());
//				System.out.println(na.getCity());
				trail.setAddress(na);
				trail.setAltitude(trails.get(i).getHigh());
				trail.setDistance(trails.get(i).getLength());
				trail.setName(trails.get(i).getName());
				trail.setDescription(trails.get(i).getSummary());
				trail.setImage(trails.get(i).getImgMedium());
				trail.setDifficulty(difficulty);
				
				em.getTransaction().begin();
				em.persist(trail);
				em.flush();
				em.getTransaction().commit();
			} 
		}
		em.close();
		emf.close();
	}
}

