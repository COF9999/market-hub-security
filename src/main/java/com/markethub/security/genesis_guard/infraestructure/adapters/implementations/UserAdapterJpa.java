package com.markethub.security.genesis_guard.infraestructure.adapters.implementations;

import com.markethub.security.genesis_guard.domain.port.UserPersistencePort;
import com.markethub.security.genesis_guard.infraestructure.adapters.interfaces.UserRepository;
import com.markethub.security.genesis_guard.infraestructure.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public class UserAdapterJpa implements UserPersistencePort {

    private final UserRepository userRepository;

    public UserAdapterJpa(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
