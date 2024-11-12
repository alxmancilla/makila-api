package org.makila.api.repository.postgresql;

import org.makila.api.model.postgresql.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {
    List<Film> findByTitleContainingIgnoreCase(String title);
    List<Film> findByReleaseYear(Integer year);
    
    @Query("SELECT f FROM Film f WHERE f.rentalRate <= :maxRate")
    List<Film> findFilmsWithinRentalRate(Double maxRate);
}