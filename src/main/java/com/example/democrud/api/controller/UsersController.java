package com.example.democrud.api.controller;

import com.example.democrud.api.request.userdto.CreateUserDto;
import com.example.democrud.api.request.userdto.RequestFindUserDto;
import com.example.democrud.api.request.userdto.ResponseFindUserDto;
import com.example.democrud.application.service.UsersService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UsersController {

    private final UsersService usersService;

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        log.info("create user : {}", createUserDto);
        usersService.createUser(createUserDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/find")
    public ResponseEntity<ResponseFindUserDto> findUser(@RequestBody @Valid RequestFindUserDto requestFindUserDto) {
        ResponseFindUserDto findUser = usersService.findUser(requestFindUserDto);
        return new ResponseEntity<>(findUser, HttpStatus.OK);
    }

}
