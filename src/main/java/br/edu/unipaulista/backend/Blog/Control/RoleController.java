package br.edu.unipaulista.backend.Blog.Control;

import br.edu.unipaulista.backend.Blog.domainModel.Role;
import br.edu.unipaulista.backend.Blog.domainModel.repositories.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleRepository repository;

    @GetMapping
    public ResponseEntity<List<Role>> findAll() {
        return ResponseEntity.ok(this.repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Role> findById(@PathVariable Long id) {
        return ResponseEntity.of(this.repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Role> create(@RequestBody Role r) {
        Role saved = this.repository.save(r);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Role> update(@RequestBody Role r) {
        Role saved = this.repository.save(r);
        return ResponseEntity.ok(saved);
    }

    @PatchMapping
    public ResponseEntity<Role> patch(@RequestBody Role r) {
        Role saved = this.repository.save(r);
        return ResponseEntity.ok(saved);
    }
}
