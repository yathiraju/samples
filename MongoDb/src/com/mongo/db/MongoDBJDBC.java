package com.mongo.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class MongoDBJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// To connect to mongodb server
			@SuppressWarnings("resource")
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			// Now connect to your databases
			@SuppressWarnings("deprecation")
			DB db = mongoClient.getDB("yathiraju");
			System.out.println("Connect to database successfully");
			/* boolean auth = db.authenticate(myUserName, myPassword); */
			System.out.println("Authentication: ");
			DBCollection coll = db.getCollection("mycol");
			System.out.println("Collection mycol selected successfully");
			BasicDBObject doc = new BasicDBObject("title", "java")
					.append("description", "java").append("likes", 10)
					.append("url", "http://www.tutorialspoint.com/mongodb/")
					.append("by", "tutorials point");
			coll.insert(doc);
			System.out.println("Document inserted successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}
