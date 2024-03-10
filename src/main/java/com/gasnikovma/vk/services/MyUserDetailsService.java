package com.gasnikovma.vk.services;

import com.gasnikovma.vk.MyUserDetails;
import com.gasnikovma.vk.models.dbentity.User;
import com.gasnikovma.vk.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByName(username);

        MyUserDetails userDetails = user.map(MyUserDetails::new).orElseThrow();
        log.info(userDetails.getAuthorities().toString());
        return user.map(MyUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
    }
}