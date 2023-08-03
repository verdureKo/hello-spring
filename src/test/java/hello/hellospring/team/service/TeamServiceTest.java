package hello.hellospring.team.service;

import hello.hellospring.team.entity.Team;
import hello.hellospring.team.repository.TeamRepository;
import hello.hellospring.Occation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
class TeamServiceTest {

    @Autowired
    Occation Occation;
    @Autowired
    TeamService teamService;
    @Autowired
    TeamRepository teamRepository;

    @BeforeEach
    void beforeEach() {
        Occation.reset();
    }

    @Test
    public void 팀_저장() {
        // given
        Occation.팀_생성();
        Team expactTeam = Occation.getTeam();

        // when
        long id = teamService.save(expactTeam);
        Optional<Team> resultTeam = teamRepository.findById(id);

        // then
        assertThat(resultTeam.get().getId()).isEqualTo(expactTeam.getId());
    }

    @Test
    public void 팀_조회() {
        // given
        Occation.여러_팀_등록();
        Team expactTeam = Occation.getTeams().get(2);

        // when
        Optional<Team> resultTeam = teamService.findTeam(expactTeam);

        // then
        assertThat(resultTeam.get().getId()).isEqualTo(expactTeam.getId());

    }

}