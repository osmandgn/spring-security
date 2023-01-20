package com.tpe.security.service;

import com.tpe.domain.*;
import com.tpe.domain.User;
import com.tpe.exception.*;
import com.tpe.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    // !!! bu classda amacım : UserDetails(User) ve GrantedAuthorities(Role)

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           User user = userRepository.findByUserName(username).orElseThrow(
                   ()-> new ResourceNotFoundException("user not found username : " + username)
           );

           if(user != null) {
               return new org.
                       springframework.
                       security.
                       core.
                       userdetails.
                       User(user.getUserName(),
                            user.getPassword(),
                               buildGrantedAuthorities(user.getRoles()));
           } else {
               throw new UsernameNotFoundException("user not found username : " + username);
           }

    }

    private static List<SimpleGrantedAuthority> buildGrantedAuthorities(final Set<Role> roles) {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role :roles) {
            authorities.add( new SimpleGrantedAuthority(role.getName().name()));
        }

        return authorities;
    }
}
