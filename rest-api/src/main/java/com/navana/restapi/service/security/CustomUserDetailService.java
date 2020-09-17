package com.navana.restapi.service.security;

import com.navana.restapi.controller.advice.exception.CUserNotFoundException;
import com.navana.restapi.entity.User;
import com.navana.restapi.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;

    public UserDetails loadUserByUsername(String userPk) {
        User user = userJpaRepo.findById(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
        if(user==null) {
            throw new UsernameNotFoundException(userPk);
        }
        return user;
    }
}