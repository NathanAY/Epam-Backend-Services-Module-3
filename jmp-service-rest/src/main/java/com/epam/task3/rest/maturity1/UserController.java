package com.epam.task3.rest.maturity1;


import com.epam.task3.dto.user.UserRequestDto;
import com.epam.task3.dto.user.UserResponseDto;
import com.epam.task3.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("UserControllerMaturityLevel1")
@AllArgsConstructor
@RequestMapping("/v1")
public class UserController {

    private UserService service;

    @PostMapping("/getUser/{id}")
    public UserResponseDto getUser(@PathVariable Long id) {
        UserResponseDto user = service.getUser(id);
        return user;
    }

    @PostMapping("/getAllUser")
    public List<UserResponseDto> getAllUsers() {
        List<UserResponseDto> users = service.getAllUsers();
        return users;
    }

    @PostMapping("/createUser")
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto responseDto = service.createUser(userRequestDto);
        return responseDto;
    }

    @PostMapping("/updateUser")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        userRequestDto.setId(id);
        return service.updateUser(userRequestDto);
    }

    @PostMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return true;
    }
}
