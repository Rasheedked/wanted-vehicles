package com.example.demo.Security.Repos;

import com.example.demo.Security.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

User findByUsername(String username);


}
