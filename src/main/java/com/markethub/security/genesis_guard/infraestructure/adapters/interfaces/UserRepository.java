package com.markethub.security.genesis_guard.infraestructure.adapters.interfaces;

import com.markethub.security.genesis_guard.infraestructure.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByEmail(String email);
}
