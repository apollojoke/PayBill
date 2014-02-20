package models;
import java.util.*;

public class Bill {
    private List<Partner> partners;
    private List<ConsumptionRecord> records;
    public Bill() {
        partners = new ArrayList<Partner>();
        records = new ArrayList<ConsumptionRecord>();
    }

    public void addPartner(){
        partners.add(new Partner());
    }

    public void addRecord(){
        records.add(new ConsumptionRecord());
    }

}
