package org.zolusca.inc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zolusca.inc.Entities.Genre;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Short> {

    Optional<Genre> findByName(String name);
}
