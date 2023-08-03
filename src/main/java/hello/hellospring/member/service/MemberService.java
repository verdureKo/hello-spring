package hello.hellospring.member.service;

import hello.hellospring.member.entity.Member;
import hello.hellospring.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent( m -> {
                    throw new IllegalStateException(" 이미 존재하는 회원입니다. ");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findMember(Member member) {
        return memberRepository.findById(member.getId());
    }

    public List<Member> findMemberWithAge(Member member) {
        return memberRepository.findAllByName(member.getName());
    }

    public Optional<Member> findMemberWithNameAndAge(Member member) {
        return memberRepository.findByNameAndAge( member.getName() , member.getAge() );
    }

    /* 성인회원 조회 */
    public List<Member> findMemberGreaterThanEqual(Member member) {
        return memberRepository.findByAgeGreaterThanEqual(member.getAge());
    }


    /* 회원 삭제 */
    public void deleteMember(Member member) {
        memberRepository.delete(member);
    }


    public List<Member> findByAgeGraterThanEqual(Member member) {
        return memberRepository.findByAgeLessThanEqual(member.getAge());
    }

    public void deleteAllByAgeLessThanEqual( Member member ) {
        memberRepository.deleteAllByAgeLessThanEqual(member.getAge());
    }

    public void deleteAllMember() {
        memberRepository.deleteAllInBatch();
    }

    public List<Member> findMemberWithCity(Member member) {
        return memberRepository.findByCity(member.getCity());
    }
}
