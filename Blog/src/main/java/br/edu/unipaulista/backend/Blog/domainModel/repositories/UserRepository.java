package br.edu.unipaulista.backend.Blog.domainModel.repositories;

import br.edu.unipaulista.backend.Blog.domainModel.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository <User, UUID>{

    @Query(" SELECT u FROM User u WHERE u.email=:email")

public Optional<User> findByEmail(String email);

    public Optional<User> findByName(String name);

    public Optional<User> findByEmail(String name, String email);

    public List<User> findAllByNameStartingWithAndEndingWith(String name1, String name2);

}
