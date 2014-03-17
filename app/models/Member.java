package models;

import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Member {
    @Id
    public Long id;
    @Constraints.Required
    public String name;

    @ManyToOne
    private Bill bill;

    public Member(String name) {
        this.name = name;
    }
}
