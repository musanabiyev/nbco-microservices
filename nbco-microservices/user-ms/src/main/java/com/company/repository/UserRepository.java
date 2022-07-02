package com.company.repository;

import com.company.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUsername(String username);

    Optional<User> findUserByUsernameOrEmail(String username, String email);

    Optional<User> findUserByEmail(String email);

    User findUserByUsernameAndPassword(String username, String password);

    User findUserByPhone(String phone);

    boolean existsById(Long id);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByPhone(@NotBlank String phone);
}
