package com.epam.task3.rest.maturity3;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.epam.task3.dto.user.UserRequestDto;
import com.epam.task3.dto.user.UserResponseDto;
import com.epam.task3.service.UserService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v3/users")
public class UserController {

    private UserService service;

    @GetMapping("/{id}")
    public EntityModel<UserResponseDto> getUser(@PathVariable Long id) {
        UserResponseDto user = service.getUser(id);

        Long userId = user.getId();
        Link selfLink = linkTo(UserController.class).slash(userId).withSelfRel();
        user.add(selfLink);
        if (user.getSubscriptions() != null && !user.getSubscriptions().isEmpty()) {
            Link subscriptinsLink = linkTo(methodOn(SubscriptionController.class)
                .getSubscription(userId)).withRel("userSubscriptions");
            user.add(subscriptinsLink);
        }

        Link link = linkTo(UserController.class).withSelfRel();
        EntityModel<UserResponseDto> result = EntityModel.of(user, link);
        return result;
    }

    @GetMapping
    public CollectionModel<UserResponseDto> getAllUsers() {
        List<UserResponseDto> users = service.getAllUsers();

        for (UserResponseDto user : users) {
            Long userId = user.getId();
            Link selfLink = linkTo(UserController.class).slash(userId).withSelfRel();
            user.add(selfLink);
            if (user.getSubscriptions() != null && !user.getSubscriptions().isEmpty()) {
                Link subscriptinsLink = linkTo(methodOn(SubscriptionController.class)
                    .getSubscription(userId)).withRel("userSubscriptions");
                user.add(subscriptinsLink);
            }
        }

        Link link = linkTo(UserController.class).withSelfRel();
        CollectionModel<UserResponseDto> result = CollectionModel.of(users, link);
        return result;
    }

    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto responseDto = service.createUser(userRequestDto);
        return responseDto;
    }

    @PutMapping("/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserRequestDto userRequestDto) {
        userRequestDto.setId(id);
        return service.updateUser(userRequestDto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        service.deleteUser(id);
        return true;
    }
}
