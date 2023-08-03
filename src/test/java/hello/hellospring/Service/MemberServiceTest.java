package hello.hellospring.Service;

import hello.hellospring.Domain.Member;
import hello.hellospring.Repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("Hello1");

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
        assertEquals( e.getMessage() , " 이미 존재하는 회원입니다. ");
    }


    @Test
    void findMembers() {
    }

    @Test
    void findMember() {
    }
}