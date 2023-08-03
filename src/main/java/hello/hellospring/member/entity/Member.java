package hello.hellospring.member.entity;

import hello.hellospring.team.entity.Team;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int age;
    private String city;
    private String street;
    private String zipcode;
    @JoinColumn(name = "team_id")
    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL )
    private Team team;


    public Member() {

    }

    public Member(String name, int age, String city, String street, String zipcode, Team team) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
        this.team = team;
    }

    public void changeTeam(Team team ){
        this.team = team;
        this.team.getMembers().add(this);
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getZipcode() {
        return zipcode;
    }
}
