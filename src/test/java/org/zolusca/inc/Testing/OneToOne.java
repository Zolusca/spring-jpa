package org.zolusca.inc.Testing;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zolusca.inc.Entities.Role;
import org.zolusca.inc.Entities.RoleType;
import org.zolusca.inc.Entities.User;
import org.zolusca.inc.Repository.RoleRepository;
import org.zolusca.inc.Repository.UserRepository;

import java.util.Optional;

@SpringBootTest
public class OneToOne {
    @Autowired private RoleRepository roleRepository;
    @Autowired private UserRepository userRepository;

    private final String USERNAME_USER = "sample";
    private final RoleType NAME_ROLE     = RoleType.ADMIN;

    @Test
    @Order(2)
    @DisplayName("find role")
    void findRole(){
        Optional<Role> role = roleRepository.findByroleType(NAME_ROLE);

        Assertions.assertNotNull(role);
    }

    @Test
    @Order(5)
    @DisplayName("delete role")
    void deleteRole(){
        Assertions.assertDoesNotThrow(()->{
            Optional<Role> role = roleRepository.findByroleType(NAME_ROLE);

            roleRepository.delete(role.get());
        });
    }

    @Test
    @Order(3)
    @DisplayName("find user")
    void findUser(){
        Optional<User> user = userRepository.findByUsername(USERNAME_USER);
        Assertions.assertNotNull(user);
    }

    @Test
    @Order(4)
    @DisplayName("delete user")
    void deleteUser(){
        Assertions.assertDoesNotThrow(()->{
            Optional<User> user = userRepository.findByUsername(USERNAME_USER);
            userRepository.delete(user.get());
        });
    }

    @Test
    @Order(1)
    @DisplayName("insert role dan user")
    void insertAll(){
        Role role = new Role();
        role.setRoleType(NAME_ROLE);

        User user = new User();
        user.setUsername(USERNAME_USER);
        user.setRole(role);

        userRepository.save(user);
    }
}
