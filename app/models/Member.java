package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
public class Member extends Model {
    @Id
    public Long id;
    @Constraints.Required
    public String name;
    public float money;

    @ManyToOne
    private Bill bill;

    public Member(String name) {
        this.name = name;
    }

    public static Finder<Long, Member> find = new Finder(Long.class, Member.class);

    public static List<Member> all() {
        return find.all();
    }

    public static List<Member> searchByBill(Bill bill) {
        return find.where().like("bill", "%" + bill + "%").findList();
    }
}
