package com.project2.smartfactory.users;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public List<Users> getList() {
        return this.usersRepository.findAll();
    }

    public void create(String userId, String password, String username, String email) {
        Users user = new Users();
        user.setUserId(userId);
        user.setPassword(password);
        user.setUsername(userId);
        user.setEmail(email);
        user.setCreateDate(LocalDateTime.now());
        this.usersRepository.save(user);

    }

}
