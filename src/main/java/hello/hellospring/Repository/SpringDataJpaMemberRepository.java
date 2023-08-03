package hello.hellospring.Repository;

import hello.hellospring.Domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, String> {

    Optional<Member> findById(long id);

    List<Member> findByAgeGreaterThanEqual( long age );

    Optional<Member> findByName(String name);

    Optional<Member> findByNameAndAge(String name , long age);

    List<Member> findAllByName(String name);

    List<Member> findByAgeLessThanEqual(long age);

    void deleteAllByAgeLessThanEqual(long age);
}