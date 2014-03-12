package models;

public class Bill {
    private static int age = 1;
    private String id;
    private String name;
    private String[] members;


    public Bill(String billName) {
        age = ++age;
        id = billName;
        name = billName;
        members = new String[0];
    }


    public static int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public static void setAge(int age) {
        Bill.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String[] getMembers() {
        return members;
    }

    public void setMembers(String[] members) {
        this.members = members;
    }
}
