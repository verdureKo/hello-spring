package hello.hellospring.Repository;

import hello.hellospring.Domain.Team;
import hello.hellospring.Domain.TeamName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaTeamRepository extends JpaRepository<Team,String> {
    Team findByTeamName(TeamName teamName);
}