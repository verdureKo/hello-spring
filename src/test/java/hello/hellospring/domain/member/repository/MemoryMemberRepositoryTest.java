package hello.hellospring.domain.member.repository;/*
package hello.hellospring.Repository;

import hello.hellospring.domain.member.entity.Member.Member;
import org.junit.jupiter.api.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemberRepository memberRepository = new MemoryMemberRepository();

    static Member member1 = new Member();
    static Member member2 = new Member();



    @BeforeAll
    static void beforeAll(){
        member1.setName("spring1");
        member2.setName("spring2");
    }



    @Test
    @Timeout(value = 1 , unit = TimeUnit.MILLISECONDS)
    public void save(){
        memberRepository.save(member1);
        Member result = memberRepository.findById(member1.getId()).get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findByName(){
        memberRepository.save(member1);
        memberRepository.save(member2);
        Member result = memberRepository.findByName("spring1").get();
        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll(){
        memberRepository.save(member1);
        memberRepository.save(member2);
        List<Member> result = memberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }


}
*/
