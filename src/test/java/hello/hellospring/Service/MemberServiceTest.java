package hello.hellospring.Service;

import hello.hellospring.Domain.Member;
import hello.hellospring.Repository.SpringDataJpaMemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    SpringDataJpaMemberRepository memberRepository;


    @Test
    void 회원가입() {
        // given
        Member member = new Member("Hello1", 35);

        // when
        Long saveId = memberService.join(member);
        // then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }
    @Test
    void 중복_회원_예외() {
        // given
        Member member = new Member("Hello1", 35);

        // when
        memberService.join(member);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member));
        assertEquals(e.getMessage(), " 이미존재하는 회원입니다. ");
    }


    @Test
    void 전체회원_조회() {
        // given
        List<Member> members = new ArrayList<Member>();
        for (int i = 0; i < 10; i++) {
            Member member = new Member("hello" + i, 35);
            members.add(member);
            memberService.join(member);
        }

        // when
        List<Member> findMembers = memberService.findMembers();

        // then
        assertThat(members).isEqualTo(findMembers);

    }

    @Test
    void 회원_조회_withId() {
        // given
        Member expectedMember = new Member();
        for (int i = 0; i < 10; i++) {
            Member member = new Member("hello" + i, 10 + i);
            if (i == 5) expectedMember = member;
            memberService.join(member);
        }

        // when
        Member targetMember = expectedMember;
        Optional<Member> resultMember = memberService.findMember(targetMember);

        // then
        assertThat(resultMember.get()).isEqualTo(expectedMember);

    }


    @Test
    void 회원_조회_WithAge() {
        // given
        List<Member> expectedMembers = new ArrayList<Member>();

        for (int i = 0; i < 10; i++) {
            Member member = new Member("hello" + i, 10 + i);
            memberService.join(member);
            if (i >= 5) expectedMembers.add(member);
        }

        // when
        Member targetMember = new Member();
        targetMember.setAge(15);
        List<Member> resultMembers = memberService.findMemberWithAge(targetMember);

        // then
        assertThat(resultMembers).isEqualTo(expectedMembers);

    }


    @Test
    void 회원_조회_WithNameAndAge() {
        // given
        Member expectedMember = new Member();
        for (int i = 0; i < 10; i++) {
            Member member = new Member("hello" + i, 10 + i);
            if (i == 5) expectedMember = member;
            memberService.join(member);
        }

        // when
        Member targetMember = expectedMember;
        Optional<Member> resultMember = memberService.findMember(targetMember);

        // then
        assertThat(resultMember.get()).isEqualTo(expectedMember);
    }

    @Test
    void 회원_수정() {
        // given
        Member expactMember = new Member("hello11", 10);
        memberService.join(expactMember);

        // when
        expactMember.setAge(99);
        Optional<Member> resultMember = memberService.findMember(expactMember);

        // then
        assertThat(resultMember.get()).isEqualTo(expactMember);
    }

    @Test
    void 성인회원_목록_조회(){
        // given
        List<Member> expectedMember = new ArrayList<Member>();
        for (int i = 0; i < 10; i++) {
            int age = (i<5)? 10 : 20;
            Member member = new Member("hello"+i, age+i);
            if (i == 5) expectedMember.add(member);
            memberService.join(member);
        }

        // when
        Member targetMember = new Member(20);
        List<Member> resultMembers = memberService.findMemberGreaterThanEqual(targetMember);

        // then
        assertThat(resultMembers).isEqualTo(expectedMember);
    }


    @Test
    void 회원_삭제() {
        // given
        Member member = new Member("hello11",10);
        memberService.join(member);

        // when
        memberService.deleteMember(member);
        Optional<Member> resultMember = memberService.findMember(member);

        // then
        assertFalse(resultMember.isPresent());
    }

    @Test
    void 전체회원_삭제() {
        // given
        for (int i = 0; i < 10; i++) {
            Member member = new Member("hello"+i, 20+i);
            memberService.join(member);
        }

        // when
        memberService.deleteAllMember();
        List<Member> resultMembers = memberService.findMembers();

        // then
        assertThat(resultMembers).isEmpty();
    }

    @Test
    void 미성년자_삭제(){
        // given
        for (int i = 0; i < 10; i++) {
            int age = (i<5)? 10 : 20;
            Member member = new Member("hello"+i, age+i);
            memberService.join(member);
        }

        // when
        Member targetMember = new Member(19);
        memberService.deleteAllByAgeLessThanEqual(targetMember);
        List<Member> resultMembers = memberService.findByAgeGraterThanEqual(targetMember);

        // then
        assertThat(resultMembers).isEmpty();
    }

}