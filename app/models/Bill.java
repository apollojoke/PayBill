package models;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bill extends Model{
    @Id
    public Long id;
    @Required
    public String name;
    @Required
    @OneToMany(mappedBy="bill", cascade= CascadeType.ALL)
    public List<Member> members;

    public static Finder<Long, Bill> find = new Finder(Long.class, Bill.class);

    public Bill(String billName, List<Member> memberList) {
        this.name = billName;
        this.members = memberList;
    }

    public Bill() {
    }

    public static List<Bill> all() {
        return find.all();
    }

    public static void create(Bill bill) {
        bill.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

}
