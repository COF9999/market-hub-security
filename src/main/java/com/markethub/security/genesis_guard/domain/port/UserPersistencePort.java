package com.markethub.security.genesis_guard.domain.port;

import com.markethub.security.genesis_guard.infraestructure.models.User;

import java.util.Optional;

public interface UserPersistencePort {

    Optional<User> findUserByEmail(String name);
}
