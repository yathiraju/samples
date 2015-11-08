package com.mongo.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class MongoDbjdbdRetrieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try{   
			 // To connect to mongodb server
		         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		         // Now connect to your databases
		         @SuppressWarnings("deprecation")
				DB db = mongoClient.getDB("yathiraju");
			 System.out.println("Connect to database successfully");   
		         DBCollection coll = db.getCollection("mycol");
		         System.out.println("Collection mycol selected successfully");
		         DBCursor cursor = coll.find();
		         int i=1;
		         while (cursor.hasNext()) { 
		            System.out.println("Inserted Document: "+i); 
		            System.out.println(cursor.next()); 
		            i++;
		         }
		      }catch(Exception e){
			     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			  }

	}

}
