package hello.hellospring.domain.member.entity;

import hello.hellospring.domain.team.entiry.Team;
import jakarta.persistence.*;

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

    @Entity
    public static class Member {
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

    public static class MemberForm {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
