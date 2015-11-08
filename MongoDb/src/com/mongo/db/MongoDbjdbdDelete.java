package com.mongo.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MongoDbjdbdDelete {
	public static void main(String[] args) {
		 try{   
			 // To connect to mongodb server
		         MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
		         // Now connect to your databases
		         DB db = mongoClient.getDB("yathiraju");  
		         DBCollection coll = db.getCollection("mycol");
		         System.out.println("Collection mycol selected successfully");
		         DBObject myDoc = coll.findOne();
		         coll.remove(myDoc);
		         DBCursor cursor = coll.find();
		         int i=1;
		         while (cursor.hasNext()) { 
		            System.out.println("Inserted Document: "+i); 
		            System.out.println(cursor.next()); 
		            i++;
		         }
		         System.out.println("Document deleted successfully");
		      }catch(Exception e){
			     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			  }
	}

}
