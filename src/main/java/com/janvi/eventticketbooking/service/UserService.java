package com.janvi.eventticketbooking.service;

import com.janvi.eventticketbooking.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
        List<User> getAllUsers();
        User getUserById(Long id);
        User updateUser(Long id, User user);
        void deleteUser(Long id);

    }


