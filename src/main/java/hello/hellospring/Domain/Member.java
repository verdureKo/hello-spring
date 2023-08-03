package hello.hellospring.Domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private long age;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private  Team team;

    public Member() {
    }
    public Member(long age) {
        this.age = age;
    }
    public Member(String name, long age) {
        this.name = name;
        this.age = age;
    }

    public Member(String name, long age, Team team) {
        this.name = name;
        this.age = age;
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getAge() {
        return age;
    }
    public void setAge(long age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", team=" + team.toString() +
                '}';
    }
}