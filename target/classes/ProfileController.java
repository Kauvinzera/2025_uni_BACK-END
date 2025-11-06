package br.edu.unipaulista.backend.Blog.Control;

import br.edu.unipaulista.backend.Blog.domainModel.Profile;
import br.edu.unipaulista.backend.Blog.domainModel.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileRepository repository;

    @GetMapping
    public ResponseEntity<List<Profile>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Profile> create(@RequestBody Profile p) {
        Profile saved = this.repository.save(p);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Profile> update(@RequestBody Profile p) {
        Profile saved = this.repository.save(p);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping
    public ResponseEntity<Profile> patch(@RequestBody Profile p) {
        Profile saved = this.repository.save(p);
        return ResponseEntity.ok(saved);
    }
}
