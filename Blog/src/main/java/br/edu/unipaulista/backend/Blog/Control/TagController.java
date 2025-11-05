package br.edu.unipaulista.backend.Blog.Control;

import br.edu.unipaulista.backend.Blog.domainModel.Tag;
import br.edu.unipaulista.backend.Blog.domainModel.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagRepository repository;

    @GetMapping
    public ResponseEntity<List<Tag>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Tag> create(@RequestBody Tag t) {
        Tag saved = this.repository.save(t);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Tag> update(@RequestBody Tag t) {
        Tag saved = this.repository.save(t);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping
    public ResponseEntity<Tag> patch(@RequestBody Tag t) {
        Tag saved = this.repository.save(t);
        return ResponseEntity.ok(saved);
    }
}
