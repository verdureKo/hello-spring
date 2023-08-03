package hello.hellospring.domain.team.entiry;

import hello.hellospring.domain.member.entity.Member;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @OneToMany( mappedBy = "team" , cascade = CascadeType.ALL )
    List<Member> members = new ArrayList<Member>();

    public Team() {
    }

    public Team(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Member> getMembers() {
        return members;
    }

    @Entity
    public static class Team {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(length=20)
        @Enumerated(EnumType.STRING)
        private TeamName name;

        public Team() {
        }

        public Team(TeamName name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Team{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
