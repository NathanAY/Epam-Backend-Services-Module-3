package com.epam.task3.service;


import com.epam.task3.dto.user.UserRequestDto;
import com.epam.task3.dto.user.UserResponseDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponseDto getUser(Long id);


    List<UserResponseDto> getAllUsers();

    UserResponseDto createUser(UserRequestDto userRequestDto);

    UserResponseDto updateUser(UserRequestDto userRequestDto);

    void deleteUser(Long id);

}
