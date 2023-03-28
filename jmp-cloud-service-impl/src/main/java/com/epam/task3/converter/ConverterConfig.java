package com.epam.task3.converter;

import com.epam.task3.dto.user.User;
import com.epam.task3.dto.user.UserResponseDto;
import com.epam.task3.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ConverterConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

//        modelMapper.createTypeMap(UserEntity.class, UserResponseDto.class)
//            .implicitMappings();
        return modelMapper;
    }
}
