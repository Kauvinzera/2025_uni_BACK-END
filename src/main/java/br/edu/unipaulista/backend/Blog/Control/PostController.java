package br.edu.unipaulista.backend.Blog.Control;

import br.edu.unipaulista.backend.Blog.domainModel.Post;
import br.edu.unipaulista.backend.Blog.domainModel.repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostRepository repository;

    @GetMapping
    public ResponseEntity<List<Post>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post p) {
        Post saved = this.repository.save(p);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Post> update(@RequestBody Post p) {
        Post saved = this.repository.save(p);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping
    public ResponseEntity<Post> patch(@RequestBody Post p) {
        Post saved = this.repository.save(p);
        return ResponseEntity.ok(saved);
    }
}
