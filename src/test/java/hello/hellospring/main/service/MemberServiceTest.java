package hello.hellospring.main.service;

import hello.hellospring.member.entity.Member;
import hello.hellospring.member.repository.MemberRepository;
import hello.hellospring.member.service.MemberService;
import hello.hellospring.team.entity.Team;
import hello.hellospring.Occation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    Occation Occation;
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @BeforeEach
    void beforeEach() {
        Occation.reset();
    }

    @Test
    void 회원가입() {
        // given
        Occation.회원_가입();
        Member member = Occation.getMember();

        // when
        Long saveId = member.getId();

        // then
        Optional<Member> findMember = memberRepository.findById(saveId);
        assertEquals(member.getName(), findMember.get().getName());

    }

    @Test
    void 중복_회원_예외() {
        // given
        Occation.회원_가입();
        Member member = Occation.getMember();

        // when
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member));

        // then
        assertEquals(e.getMessage(), " 이미존재하는 회원입니다. ");
    }


    @Test
    void 전체회원_조회() {
        // given
        Occation.여러_회원_가입();
        List<Member> members = Occation.getMembers();

        // when
        List<Member> findMembers = memberService.findMembers();

        // then
        assertThat(members).isEqualTo(findMembers);

    }

    @Test
    void 회원_조회_withId() {
        // given
        Occation.여러_회원_가입();
        Member expectedMember = Occation.getMembers().get(2);

        // when
        Optional<Member> resultMember = memberService.findMember(expectedMember);

        // then
        assertThat(resultMember.get()).isEqualTo(expectedMember);

    }


    @Test
    void 회원_조회_WithCity() {
        // given
        Occation.여러_회원_가입();
        List<Member> expectedMembers = Occation.getMembers().stream()
                .filter( member -> member.getCity().equals("서울시") )
                .collect(Collectors.toList());

        // when
        Member targetMember = new Member("" , 0 , "서울시", "", "", new Team());
        List<Member> resultMembers = memberService.findMemberWithCity(targetMember);

        // then
        assertThat(resultMembers).isEqualTo(expectedMembers);

    }


    @Test
    void 회원_조회_WithNameAndAge() {
        // given
        Occation.여러_회원_가입();
        Member expectedMember = Occation.getMembers().get(2);

        // when
        Optional<Member> resultMember = memberService.findMember(expectedMember);

        // then
        assertThat(resultMember.get()).isEqualTo(expectedMember);
    }

    @Test
    void 회원_수정() {
        // given
        Occation.회원_가입();
        Member expactMember = Occation.getMember();

        // when
        expactMember.setCity("강원도");
        Optional<Member> resultMember = memberService.findMember(expactMember);

        // then
        assertThat(resultMember.get()).isEqualTo(expactMember);
    }

    @Test
    void 성인회원_목록_조회() {
        // given
        Occation.여러_회원_가입();
        List<Member> expectedMembers = Occation.getMembers().stream()
                .filter( member -> member.getAge() >= 20 )
                .collect( Collectors.toList());

        // when
        Member targetMember = new Member("",20,"","","",new Team());
        List<Member> resultMembers = memberService.findMemberGreaterThanEqual(targetMember);

        // then
        System.out.println(resultMembers);
        System.out.println(expectedMembers);
        assertThat(resultMembers).isEqualTo(expectedMembers);
    }


    @Test
    void 회원_삭제() {
        // given
        Occation.회원_가입();
        Member member = Occation.getMember();

        // when
        memberService.deleteMember(member);
        Optional<Member> resultMember = memberService.findMember(member);

        // then
        assertFalse(resultMember.isPresent());
    }

    @Test
    void 전체회원_삭제() {
        // given
        Occation.여러_회원_가입();

        // when
        memberService.deleteAllMember();
        List<Member> resultMembers = memberService.findMembers();

        // then
        assertThat(resultMembers).isEmpty();
    }

    @Test
    void 미성년자_삭제() {
        // given
        Occation.여러_회원_가입();

        // when
        Member targetMember = new Member("" , 19 , "서울시", "", "", new Team());
        memberService.deleteAllByAgeLessThanEqual(targetMember);
        List<Member> resultMembers = memberService.findByAgeGraterThanEqual(targetMember);

        // then
        assertThat(resultMembers).isEmpty();
    }

}
