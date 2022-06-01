package com.summergroup.portal.mapper;

import com.summergroup.portal.domain.User;
import com.summergroup.portal.dto.RegistrationRequest;
import com.summergroup.portal.dto.UserDto;
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

    public UserDto toDto(User user) {
        return modelMapper.map(user, UserDto.class);
    }

    public User toEntity(UserDto userDto) {
        return modelMapper.map(userDto, User.class);
    }

    public List<UserDto> toDtoList(List<User> userList) {
        return userList.stream().map(this::toDto).collect(Collectors.toList());
    }

    public User registrationRequestToEntity(RegistrationRequest registrationRequest) {
        return modelMapper.map(registrationRequest, User.class);
    }
}
