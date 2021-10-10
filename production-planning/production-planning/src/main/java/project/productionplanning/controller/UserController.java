package project.productionplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.productionplanning.dto.UserDto;
import project.productionplanning.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UserDto userDto){
        userService.addUser(userDto);
    }

    @PutMapping("/{id}")
    public void updateUser(@RequestBody UserDto userDto, @PathVariable("id") Integer id){
        userService.updateUser(userDto, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }
}
