package com.ssb.onlineshopbackend.service;

import com.ssb.onlineshopbackend.data.UserRepository;
import com.ssb.onlineshopbackend.model.CustomUserDetails;
import com.ssb.onlineshopbackend.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        final User user = this.userRepository.findByEmail(email);
        if(user==null){
            throw new UsernameNotFoundException("User Not Found");
        }else{
            return new CustomUserDetails(user);
        }

    }

}
