package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.List;

@Entity
public class Record extends Model{
    @Id
    public Long id;
    @Constraints.Required
    public Long billId;
    @Constraints.Required
    public String payer;
    @Constraints.Required
    public int cost;
    public String subject;
    public Date date;

    public static Finder<Integer, Record> find = new Model.Finder<>(Integer.class, Record.class);

    public static void create(Record record) {
        record.save();
    }

    public static List<Record> searchByPayerAndBill(String payer, Long billId){
        return find.where().like("payer", "%" + payer + "%").like("billId", "%" + billId + "%").findList();
    }

    public static List<Record> searchByBill(Long billId) {
        return find.where().like("billId", "%" + billId + "%").findList();
    }
}
