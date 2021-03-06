package com.eltropy.bankingsystem.core.service;

import com.eltropy.bankingsystem.core.util.CustomUserDetails;
import com.eltropy.bankingsystem.user.entity.User;
import com.eltropy.bankingsystem.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException
    {
        User user = repo.findByEmail(email);
        if(user == null){
            throw new UsernameNotFoundException("User Not found");
        }
        return new CustomUserDetails(user);
    }
}
