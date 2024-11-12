package org.makila.api.controller.mongodb;


import org.makila.api.model.mongodb.RentalDocument;
import org.makila.api.service.mongodb.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;
    
    @PostMapping
    public ResponseEntity<RentalDocument> createRental(@RequestBody RentalDocument rental) {
        return ResponseEntity.ok(rentalService.createRental(rental));
    }
    
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<RentalDocument>> getCustomerRentals(@PathVariable Long customerId) {
        return ResponseEntity.ok(rentalService.getCustomerRentals(customerId));
    }
    
    @GetMapping("/film/{filmId}")
    public ResponseEntity<List<RentalDocument>> getFilmRentals(@PathVariable Long filmId) {
        return ResponseEntity.ok(rentalService.getFilmRentals(filmId));
    }
}
