package org.zolusca.inc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zolusca.inc.Entities.Role;
import org.zolusca.inc.Entities.RoleType;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Short> {
    Optional<Role> findByroleType(RoleType name);
}
