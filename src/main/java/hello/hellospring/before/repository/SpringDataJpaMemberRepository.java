package hello.hellospring.before.repository;

import hello.hellospring.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<hello.hellospring.domain.member.entity.Member.Member, String> {

    Optional<hello.hellospring.domain.member.entity.Member.Member> findById(long id);

    List<hello.hellospring.domain.member.entity.Member.Member> findByAgeGreaterThanEqual(long age );

    Optional<hello.hellospring.domain.member.entity.Member.Member> findByName(String name);

    Optional<hello.hellospring.domain.member.entity.Member.Member> findByNameAndAge(String name , long age);

    List<hello.hellospring.domain.member.entity.Member.Member> findAllByName(String name);

    List<Member.Member> findByAgeLessThanEqual(long age);

    void deleteAllByAgeLessThanEqual(long age);
}