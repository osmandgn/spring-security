package com.tpe.service;

import com.tpe.domain.*;
import com.tpe.domain.enums.*;
import com.tpe.dto.*;
import com.tpe.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public void saveUser(UserRequest userRequest) {
        User myUser = new User();
        myUser.setFirstName(userRequest.getFirstName());
        myUser.setLastName(userRequest.getLastName());
        myUser.setUserName(userRequest.getUserName());
        // myUser.setPassword(userRequest.getPassword());
        String password = userRequest.getPassword();
        String encodedPassword = passwordEncoder.encode(password);

        myUser.setPassword(encodedPassword);

        // Role setlenmeli
          Role role = roleService.getRoleByType(UserRole.ROLE_ADMIN);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        myUser.setRoles(roles);

        userRepository.save(myUser);


    }
}
