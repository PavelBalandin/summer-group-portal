package com.summergroup.portal.mapper;

import com.summergroup.portal.domain.User;
import com.summergroup.portal.dto.RegistrationRequest;
import com.summergroup.portal.dto.UserDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toEntity(UserDTO userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public List<UserDTO> toDtoList(List<User> users) {
        return users.stream().map(this::toDto).collect(Collectors.toList());
    }

    public List<User> toEntityList(List<UserDTO> userDTOs) {
        return userDTOs.stream().map(this::toEntity).collect(Collectors.toList());
    }

    public User registrationRequestToEntity(RegistrationRequest registrationRequest) {
        return modelMapper.map(registrationRequest, User.class);
    }
}
