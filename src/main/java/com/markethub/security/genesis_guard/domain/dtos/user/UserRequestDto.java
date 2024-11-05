package com.markethub.security.genesis_guard.domain.dtos.user;



import com.markethub.security.genesis_guard.infraestructure.models.Role;

import java.util.List;

public record UserRequestDto(String username,
                             String identification,
                             String password,
                             String name,
                             String email,
                             List<Role> roles) {
}
