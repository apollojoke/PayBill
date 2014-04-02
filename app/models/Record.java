package models;

import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

import javax.persistence.Id;
import java.sql.Date;
public class Record{
    @Id
    @ObjectId
    public String id;
    public String billId;
    public String payer;
    public int payerId;
    public int cost;
    public String subject;
    //public Date date;

    private static JacksonDBCollection<Record, String> coll = MongoDB.getCollection("records", Record.class, String.class);

    public static void create(Record record) {
        Record.coll.save(record);
    }
}
