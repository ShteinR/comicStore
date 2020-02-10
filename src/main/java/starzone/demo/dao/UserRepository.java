package starzone.demo.dao;

import jdk.nashorn.internal.ir.Optimistic;
import org.springframework.data.jpa.repository.JpaRepository;
import starzone.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    @Override
    <S extends User> S save(S s);

    Optional<User> findUserByUserName(String s);

}
