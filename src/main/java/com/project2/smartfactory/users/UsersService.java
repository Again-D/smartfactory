package com.project2.smartfactory.users;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public List<Users> getList() {
        return this.usersRepository.findAll();
    }

    public void create 

}
