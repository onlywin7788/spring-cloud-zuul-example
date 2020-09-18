package com.navana.restapi.service.security;

import com.navana.restapi.common.CacheKey;
import com.navana.restapi.controller.advice.exception.CUserNotFoundException;
import com.navana.restapi.entity.User;
import com.navana.restapi.repo.UserJpaRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserJpaRepo userJpaRepo;

    @Cacheable(value = CacheKey.USER, key = "#userPk", unless = "#result == null")
    public UserDetails loadUserByUsername(String userPk) {
        return userJpaRepo.findById(Long.valueOf(userPk)).orElseThrow(CUserNotFoundException::new);
    }
}