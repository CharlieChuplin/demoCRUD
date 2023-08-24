package com.example.democrud.application.service;

import com.example.democrud.api.request.userdto.CreateUserDto;
import com.example.democrud.api.request.userdto.RequestFindUserDto;
import com.example.democrud.api.request.userdto.ResponseFindUserDto;
import com.example.democrud.domain.users.Users;
import com.example.democrud.domain.users.UsersRepository;
import com.example.democrud.global.exception.usersexception.UsersErrorCode;
import com.example.democrud.global.exception.usersexception.UsersException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    @Transactional
    public ResponseFindUserDto findUser(RequestFindUserDto requestFindUserDto) {
        String name = requestFindUserDto.getUserName();
        Users findUser = usersRepository.findByUserName(name)
                .orElseThrow(() -> new UsersException(UsersErrorCode.NOT_FOUND_USER));

        return new ResponseFindUserDto(findUser.getEmail());
    }

    @Transactional
    public void createUser(CreateUserDto createUserDto) {

        usersRepository.findByEmail(createUserDto.getEmail())
                        .ifPresent((u) -> {throw new UsersException(UsersErrorCode.EXIST_NAME_USER);});

        Users newUser = createUserDto.createUser(createUserDto);
        usersRepository.save(newUser);
    }

}
