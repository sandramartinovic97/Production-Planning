package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.productionplanning.dto.RoleDto;
import project.productionplanning.dto.UserDto;
import project.productionplanning.model.User;
import project.productionplanning.repository.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = modelMapper.map(user, UserDto.class);
            userDto.setRoleId(modelMapper.map(user.getRoleId(), RoleDto.class));
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find user with id = " + id));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public UserDto addUser(UserDto user) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto user, Integer id) {
        return null;
    }

    @Override
    public void deleteUser(Integer id) {

    }

    @Override
    public UserDto getUserByUsername(String username) {
        return null;
    }
}
