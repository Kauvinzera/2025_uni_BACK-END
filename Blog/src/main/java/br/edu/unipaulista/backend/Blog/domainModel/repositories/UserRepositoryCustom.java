package br.edu.unipaulista.backend.Blog.domainModel.repositories;

import br.edu.unipaulista.backend.Blog.domainModel.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepositoryCustom<User, UUID> {
    public Optional<User> findByIdWithProfileAndPostsCriteria(UUID id);
    public List<User> findByMinRolesAndNameLikeCriteria(int minRoles, String name);

}
