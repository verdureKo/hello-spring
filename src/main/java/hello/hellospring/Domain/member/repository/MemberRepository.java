package hello.hellospring.domain.member.repository;

import hello.hellospring.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findById(long id);

    List<Member> findByAgeGreaterThanEqual( int age );

    Optional<Member> findByName(String name);

    Optional<Member> findByNameAndAge(String name , int age);

    List<Member> findAllByName(String name);

    List<Member> findByAgeLessThanEqual(int age);

    void deleteAllByAgeLessThanEqual(int age);

    List<Member> findByCity(String city);
}
