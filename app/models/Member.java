package models;

import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.ObjectId;
import play.modules.mongodb.jackson.MongoDB;

import javax.persistence.Id;
import java.util.List;

public class Member{
    @Id
    @ObjectId
//    public String id;
    public String name;
    public float money;

    private static JacksonDBCollection<Member, String> coll = MongoDB.getCollection("members", Member.class, String.class);

    public static List<Member> all() {
        return Member.coll.find().toArray();
    }

    public static List<Member> searchByBill(Bill bill) {
        return Member.coll.find().in("bill", bill).toArray();
    }

    public static void create(Member member) {
        Member.coll.save(member);
    }

    public static void update(Member member) {
        Member.coll.updateById(member.name, member);
    }
}
