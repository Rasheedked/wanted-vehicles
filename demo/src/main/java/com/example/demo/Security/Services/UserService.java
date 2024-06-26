package com.example.demo.Security.Services;

import com.example.demo.Security.Domain.Role;
import com.example.demo.Security.Domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getAllUsers();

}
