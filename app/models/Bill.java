package models;
import java.util.*;

public class Bill {
    private static int billNumber = 1;
    private int billID;
    private String name;
    private List<Partner> partners;
    private List<ConsumptionRecord> records;
    public Bill(String billName) {
        billID = billNumber ++;
        name = billName;
        partners = new ArrayList<Partner>();
        records = new ArrayList<ConsumptionRecord>();
    }

    public int getBillID() {
        return billID;
    }

    public String getName() {
        return name;
    }
}
