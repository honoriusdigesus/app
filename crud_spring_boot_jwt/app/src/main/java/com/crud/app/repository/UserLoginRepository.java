package com.crud.app.repository;

import com.crud.app.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin, Integer> {
    Optional<UserLogin> findUserByDi(BigDecimal di);
}
