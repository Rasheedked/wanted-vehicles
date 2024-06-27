package com.example.demo.Security.Services;

import com.example.demo.Security.Domain.Role;
import com.example.demo.Security.Domain.User;
import com.example.demo.Security.Repos.RoleRepo;
import com.example.demo.Security.Repos.UserRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepo userRepo;
    @Autowired
    private final RoleRepo roleRepo;


    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);

    }

    @Override
    public User getUser(String username) {

        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
