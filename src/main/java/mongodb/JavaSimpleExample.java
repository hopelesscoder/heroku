package mongodb;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class JavaSimpleExample {
	/**
	 * The uri to access mongodb
	 */
	private static final String MONGO_URI = "mongodb://heroku_kt941zzp:ils1u8nvn0oe3duo6hin4vd6cb@ds147592.mlab.com:47592/heroku_kt941zzp";
	
	public static boolean isEmpty() {
        MongoClientURI uri  = new MongoClientURI(MONGO_URI); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        MongoCollection<Document> songs = db.getCollection("songs");
        if(songs.countDocuments() > 0) {
        	client.close();
        	return false;
        }else {
        	client.close();
        	return true;
        }
	}
	
	public static List<Document> getDocumentList(){
        MongoClientURI uri  = new MongoClientURI(MONGO_URI); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        List<Document> out = new ArrayList<Document>();
        MongoCollection<Document> songs = db.getCollection("songs");
        MongoCursor<Document> cursor = songs.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                out.add(doc);
            }
        } finally {
            cursor.close();
            client.close();
        }
        return out;
	}
	
    public static void create() throws UnknownHostException{
        
        // Create seed data
        
        List<Document> seedData = new ArrayList<Document>();

        seedData.add(new Document("decade", "1970s")
            .append("artist", "Debby Boone")
            .append("song", "You Light Up My Life")
            .append("weeksAtOne", 10)
        );

        seedData.add(new Document("decade", "1980s")
            .append("artist", "Olivia Newton-John")
            .append("song", "Physical")
            .append("weeksAtOne", 10)
        );

        seedData.add(new Document("decade", "1990s")
            .append("artist", "Mariah Carey")
            .append("song", "One Sweet Day")
            .append("weeksAtOne", 16)
        );

        // Standard URI format: mongodb://[dbuser:dbpassword@]host:port/dbname
       
        MongoClientURI uri  = new MongoClientURI(MONGO_URI); 
        MongoClient client = new MongoClient(uri);
        MongoDatabase db = client.getDatabase(uri.getDatabase());
        
        /*
         * First we'll add a few songs. Nothing is required to create the
         * songs collection; it is created automatically when we insert.
         */
        
        MongoCollection<Document> songs = db.getCollection("songs");

        // Note that the insert method can take either an array or a document.
        
        songs.insertMany(seedData);
       
        /*
         * Then we need to give Boyz II Men credit for their contribution to
         * the hit "One Sweet Day".
         */

        Document updateQuery = new Document("song", "One Sweet Day");
        songs.updateOne(updateQuery, new Document("$set", new Document("artist", "Mariah Carey ft. Boyz II Men")));
        
        /*
         * Finally we run a query which returns all the hits that spent 10 
         * or more weeks at number 1.
         */
      
        Document findQuery = new Document("weeksAtOne", new Document("$gte",10));
        Document orderBy = new Document("decade", 1);

        MongoCursor<Document> cursor = songs.find(findQuery).sort(orderBy).iterator();

        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                System.out.println(
                    "In the " + doc.get("decade") + ", " + doc.get("song") + 
                    " by " + doc.get("artist") + " topped the charts for " + 
                    doc.get("weeksAtOne") + " straight weeks."
                );
            }
        } finally {
            cursor.close();
        }

        // Since this is an example, we'll clean up after ourselves.

        //songs.drop();
        
        // Only close the connection when your app is terminating

        client.close();
    }
}
