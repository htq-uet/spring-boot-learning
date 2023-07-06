package com.javatpoint.service;

import com.javatpoint.model.Users;
import com.javatpoint.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService {
    @Autowired
    UsersRepository usersRepository;
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<Users>();
        usersRepository.findAll().forEach(users1 -> users.add(users1));
        return users;
    }
    public Users getUsersById(Integer id) {
        return (Users) usersRepository.findById(id).get();
    }

    public Users getUsersByHp(int hp) {
        return (Users) usersRepository.findByHp(hp);
    }

    public Users deleteUser(int id) {
        usersRepository.deleteById(id);
        return (Users) usersRepository.findById(id).get();
    }

    public Users saveOrUpdate(Users users) {
        usersRepository.save(users);
        return users;
    }
    public void update(Users users, int id)
    {
        usersRepository.save(users);
    }
}
