package project.productionplanning.service;

import project.productionplanning.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getUsers();
    UserDto getUserById(Integer id);
    boolean existsById(Integer id);
    UserDto addUser(UserDto user);
    UserDto updateUser(UserDto user, Integer id);
    void deleteUser(Integer id);
    UserDto getUserByUsername(String username);
}
