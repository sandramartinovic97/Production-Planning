package project.productionplanning.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
    @Autowired
    private JdbcTemplate jdbcTemplate;

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
    public UserDto addUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        User updatedUser = modelMapper.map(userDto, User.class);
        User userFromDB = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Could not find user with specified id = " + id));
        userFromDB.setUserName(updatedUser.getUserName());
        userFromDB.setUserSurname(updatedUser.getUserSurname());
        userFromDB.setUserEmail(updatedUser.getUserEmail());
        //userFromDB.setUserPassword(updatedUser.getUserPassword());
        userFromDB.setRoleId(updatedUser.getRoleId());
        return modelMapper.map(userRepository.save(userFromDB), UserDto.class);
    }

    @Override
    public void deleteUser(Integer id) {
        jdbcTemplate.execute("delete from document where user_id = " + id);
        userRepository.deleteById(id);
    }

    @Override
    public UserDto getUserByUsername(String username) {
        User user = userRepository.findByUserUsername(username).orElseThrow(() -> new EntityNotFoundException("Could not find user with specified username."));
        UserDto userDto = modelMapper.map(user, UserDto.class);
        userDto.setRoleId(modelMapper.map(user.getRoleId(), RoleDto.class));
        return userDto;
    }
}
