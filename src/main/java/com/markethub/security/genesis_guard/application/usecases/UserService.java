package com.markethub.security.genesis_guard.application.usecases;

import com.markethub.security.genesis_guard.infraestructure.models.User;

public interface UserService {
    User findUserByEmail(String name);
}
