package project.productionplanning.service;

import project.productionplanning.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUserById(Integer id);
    UserDto addUser(UserDto userDto);
    UserDto updateUser(UserDto userDto, Integer id);
    void deleteUser(Integer id);
}
