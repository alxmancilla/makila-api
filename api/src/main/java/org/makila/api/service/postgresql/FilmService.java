package org.makila.api.service.postgresql;

import org.makila.api.model.postgresql.Film;
import org.makila.api.repository.postgresql.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmRepository filmRepository;
    
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }
    
    public Film getFilmById(Long id) {
        return filmRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Film not found"));
    }
    
    public List<Film> searchFilms(String title) {
        return filmRepository.findByTitleContainingIgnoreCase(title);
    }
    
    public List<Film> getFilmsByYear(Integer year) {
        return filmRepository.findByReleaseYear(year);
    }
    
    public List<Film> getFilmsWithinRentalRate(Double maxRate) {
        return filmRepository.findFilmsWithinRentalRate(maxRate);
    }
}