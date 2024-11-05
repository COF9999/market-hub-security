package com.markethub.security.genesis_guard.infraestructure.security;

import com.markethub.security.genesis_guard.domain.port.UserPersistencePort;
import com.markethub.security.genesis_guard.infraestructure.models.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceManager implements UserDetailsService {

    private final UserPersistencePort userPersistencePort;

    public UserDetailsServiceManager(UserPersistencePort userPersistencePort){
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =  userPersistencePort
                .findUserByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format("email - %s -passed not exists in the DATABASE",email)));

        List<GrantedAuthority> grantedAuthorityList = user.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.isActive(),
                true,
                true,
                true,
                grantedAuthorityList);
    }
}
