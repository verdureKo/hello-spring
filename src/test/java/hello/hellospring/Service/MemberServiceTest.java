package hello.hellospring.Service;

import hello.hellospring.Domain.Member;
import hello.hellospring.Repository.MemberRepository;
import hello.hellospring.Repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class MemberServiceTest {

    MemberService memberService;
    MemberRepository memberRepository;

    @BeforeEach
    void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    void afterEach() {
        memberRepository.clearRepository();
    }


    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("Hello");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());

    }

    @Test
    void 중복_회원_예외() {
        // given
        Member member = new Member();
        member.setName("Hello");

        // when
        memberService.join(member);

        // then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member));
        assertEquals( e.getMessage() , " 이미존재하는 회원입니다. ");
    }


    @Test
    void findMembers() {
    }

    @Test
    void findMember() {
    }
}