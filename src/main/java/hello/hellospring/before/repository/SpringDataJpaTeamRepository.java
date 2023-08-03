package hello.hellospring.before.repository;

import hello.hellospring.domain.team.entiry.Team;
import hello.hellospring.domain.team.entiry.TeamName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaTeamRepository extends JpaRepository<hello.hellospring.domain.team.entiry.Team.Team,String> {
    Team.Team findByTeamName(TeamName teamName);
}