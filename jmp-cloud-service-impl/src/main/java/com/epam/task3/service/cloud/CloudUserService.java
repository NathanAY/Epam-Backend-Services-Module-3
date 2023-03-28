package com.epam.task3.service.cloud;

import com.epam.task3.dto.user.UserRequestDto;
import com.epam.task3.dto.user.UserResponseDto;
import com.epam.task3.entity.UserEntity;
import com.epam.task3.repository.UserRepository;
import com.epam.task3.service.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CloudUserService implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Override
    public UserResponseDto getUser(Long id) {
        Optional<UserEntity> userOption = userRepository.findById(id);
        if (userOption.isEmpty()) {
            return null;
        }
        UserEntity user = userOption.get();

        UserResponseDto response = modelMapper.map(user, UserResponseDto.class);
        return response;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> userOption = userRepository.findAll();
        List<UserResponseDto> usersDto = userOption.stream()
            .map(user -> modelMapper.map(user, UserResponseDto.class))
            .collect(Collectors.toList());
        return usersDto;
    }

    @Override
    public UserResponseDto createUser(UserRequestDto userRequestDto) {
        userRequestDto.setId(null);
        UserEntity userEntity = modelMapper.map(userRequestDto, UserEntity.class);
        UserEntity saved = userRepository.save(userEntity);
        return modelMapper.map(saved, UserResponseDto.class);
    }

    @Override
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        UserEntity userEntity = modelMapper.map(userRequestDto, UserEntity.class);
        UserEntity saved = userRepository.save(userEntity);
        return modelMapper.map(saved, UserResponseDto.class);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
