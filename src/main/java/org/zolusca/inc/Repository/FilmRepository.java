package org.zolusca.inc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zolusca.inc.Entities.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film,String> {

}
