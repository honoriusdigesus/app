package com.crud.app.controller;

import com.crud.app.entity.UserLogin;
import com.crud.app.services.UserLoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("user")
public class UserLoginController {

    private UserLoginService userLoginService;

    @GetMapping("/{di}")
    public Optional<UserLogin> findUserByDi(@PathVariable BigDecimal di) {
        return ResponseEntity.ok(userLoginService.findUserByDi(di)).getBody();
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody UserLogin userLogin){
        return ResponseEntity.ok(userLoginService.save(userLogin));
    }

}
