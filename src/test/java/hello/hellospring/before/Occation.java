package hello.hellospring.before;

import hello.hellospring.domain.member.entity.Member;
import hello.hellospring.domain.member.repository.MemberRepository;
import hello.hellospring.domain.team.entiry.Team;
import hello.hellospring.domain.team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Occation {


    private Member member;
    private List<Member> members;
    private Team team;
    private List<Team> teams;

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;

    public Occation() {
        this.members = new ArrayList<Member>();
        this.teams = new ArrayList<Team>();
    }

    public void reset() {
        this.member = null;
        this.members = new ArrayList<Member>();
        this.team = null;
        this.teams = new ArrayList<Team>();
    }

    private void 회원_생성() {
        팀_생성();
        this.member = new Member("안중근", 100, "서울시", "강남구", "123-123" , this.team);
    }

    public void 회원_가입() {
        회원_생성();
        memberRepository.save(this.member);
    }

    private void 여러_회원_생성() {
        여러_팀_생성();
        this.members.add(new Member("안중근", 10, "서울시", "강남구", "123-123" , this.teams.get(0)));
        this.members.add(new Member("윤봉길", 10, "서울시", "강남구", "123-123", this.teams.get(1)));
        this.members.add(new Member("안창호", 10, "서울시", "강남구", "123-123", this.teams.get(2)));
        this.members.add(new Member("유관순", 10, "서울시", "강남구", "123-123", this.teams.get(3)));
        this.members.add(new Member("김구", 100, "서울시", "강남구", "123-123", this.teams.get(4)));
        this.members.add(new Member("이봉창", 100, "부산시", "진구", "123-123", this.teams.get(5)));
        this.members.add(new Member("이회영", 100, "부산시", "진구", "123-123", this.teams.get(6)));
        this.members.add(new Member("이순신", 500, "부산시", "진구", "123-123", this.teams.get(7)));
        this.members.add(new Member("장영실", 500, "경기도", "수원", "123-123", this.teams.get(8)));
        this.members.add(new Member("허준", 500, "경기도", "수원", "123-123", this.teams.get(9)));
    }

    public void 여러_회원_가입() {
        여러_회원_생성();
        for (Member member : this.members) {
            memberRepository.save(member);
        }
    }

    public void 팀_생성() {
        this.team = new Team("개발팀");
    }

    public void 팀_등록() {
        팀_생성();
        teamRepository.save(this.team);
    }

    public void 여러_팀_생성() {
        this.teams.add(new Team("경영지원"));
        this.teams.add(new Team("기획"));
        this.teams.add(new Team("생산"));
        this.teams.add(new Team("품질"));
        this.teams.add(new Team("개발"));
        this.teams.add(new Team("재무"));
        this.teams.add(new Team("구매"));
        this.teams.add(new Team("자재"));
        this.teams.add(new Team("인사"));
        this.teams.add(new Team("감사"));
        this.teams.add(new Team("법무"));
    }

    public void 여러_팀_등록() {
        여러_팀_생성();
        this.teams.forEach(team -> teamRepository.save(team));
    }



    /*================================================================================================================*/
    /*   Getter & Setter   */
    /*================================================================================================================*/


    public Member getMember() {
        return member;
    }

    public List<Member> getMembers() {
        return members;
    }

    public Team getTeam() {
        return team;
    }

    public List<Team> getTeams() {
        return teams;
    }
}
