package models;

import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

import javax.persistence.Id;
import java.util.List;

public class Bill{
    @Id
    @ObjectId
    public String id;
    public String name;
    public List<Member> members;

    private static JacksonDBCollection<Bill, String> coll = MongoDB.getCollection("bills", Bill.class, String.class);

    public Bill(String billName, List<Member> memberList) {
        this.name = billName;
        this.members = memberList;
    }

    public Bill() {
    }

    public static List<Bill> all() {
        return Bill.coll.find().toArray();
    }

    public static void create(Bill bill) {
        Bill.coll.save(bill);
    }

    public static Bill findById(String id) {
        return Bill.coll.findOneById(id);
    }

}
