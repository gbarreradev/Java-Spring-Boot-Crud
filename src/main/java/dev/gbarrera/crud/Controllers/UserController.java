package dev.gbarrera.crud.Controllers;

import dev.gbarrera.crud.Services.UserService;
import dev.gbarrera.crud.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(path="/{id}")
    public Optional<UserModel> getById(@PathVariable("id") Long id){
        return userService.getById(id);
    }

    @GetMapping(path="/query")
    public ArrayList<UserModel> getByPriority(@RequestParam("priority") Integer priority){
        return userService.getByPriority(priority);
    }

    @DeleteMapping(path="/{id}")
    public Boolean deleteById(@PathVariable("id") Long id){
        return this.deleteById(id);
    }

    @PostMapping()
    public UserModel saveUser(@RequestBody UserModel user){
        return this.userService.saveUser(user);
    }


}
