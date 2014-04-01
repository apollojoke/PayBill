package mongo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

public class MongoDBProxy {
    MongoClient mongoClient;
    static DB db;

    public MongoDBProxy() throws UnknownHostException {
        mongoClient = new MongoClient("localhost", 27017);
        db = mongoClient.getDB("mydb");
    }

    public static DBCollection getCollection(String collection){
       return db.getCollection(collection);
    }

}
