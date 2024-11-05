package com.markethub.security.genesis_guard.application.services;

import com.markethub.security.genesis_guard.application.usecases.UserService;
import com.markethub.security.genesis_guard.domain.port.UserPersistencePort;
import com.markethub.security.genesis_guard.infraestructure.models.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserPersistencePort userRepository;

    public UserServiceImpl(UserPersistencePort userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public User findUserByEmail(String name) {
        return null;
    }
}
