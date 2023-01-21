package com.tpe.service;

import com.tpe.domain.*;
import com.tpe.domain.enums.*;
import com.tpe.exception.*;
import com.tpe.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;
    public Role getRoleByType(UserRole roleType) {
        Role role = roleRepository.findByName(roleType).orElseThrow(
                ()-> new ResourceNotFoundException("Role bulunamadı")
        );
        return role;

    }
}
