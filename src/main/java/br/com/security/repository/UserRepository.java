package br.com.security.repository;

import br.com.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u from User u JOIN FETCH u.roles where u.username = :username")
    User findByUsernameFecthRoles(@Param("username") String username);
}
