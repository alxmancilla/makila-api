package org.makila.api.controller.postgresql;

import org.makila.api.model.postgresql.Film;
import org.makila.api.service.postgresql.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;
    
    @GetMapping
    public ResponseEntity<List<Film>> getAllFilms() {
        return ResponseEntity.ok(filmService.getAllFilms());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable Long id) {
        return ResponseEntity.ok(filmService.getFilmById(id));
    }
    
    @GetMapping("/search")
    public ResponseEntity<List<Film>> searchFilms(@RequestParam String title) {
        return ResponseEntity.ok(filmService.searchFilms(title));
    }
    
    @GetMapping("/year/{year}")
    public ResponseEntity<List<Film>> getFilmsByYear(@PathVariable Integer year) {
        return ResponseEntity.ok(filmService.getFilmsByYear(year));
    }
    
    @GetMapping("/rental-rate")
    public ResponseEntity<List<Film>> getFilmsWithinRentalRate(@RequestParam Double maxRate) {
        return ResponseEntity.ok(filmService.getFilmsWithinRentalRate(maxRate));
    }
}