package hello.hellospring.Domain;


import jakarta.persistence.*;

@Entity
public class Team {

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