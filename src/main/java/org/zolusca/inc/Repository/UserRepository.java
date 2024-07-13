package org.zolusca.inc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zolusca.inc.Entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUsername(String name);
}
