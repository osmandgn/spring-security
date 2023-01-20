package com.tpe.repository;

import com.tpe.domain.*;
import com.tpe.exception.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> findByUserName(String userName) throws ResourceNotFoundException;
}
