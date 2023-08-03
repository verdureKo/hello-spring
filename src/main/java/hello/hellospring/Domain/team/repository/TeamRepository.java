package hello.hellospring.domain.team.repository;

import hello.hellospring.domain.team.entiry.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TeamRepository extends JpaRepository< Team,String> {

    Optional<Team> findById( long id );

    Optional<Team> findByName(String name);

}
