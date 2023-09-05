package com.example.calendarcore.service;

import com.example.calendarcore.domain.entity.User;
import com.example.calendarcore.domain.entity.repository.UserRepository;
import com.example.calendarcore.dto.UserCreateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional

    public User create(UserCreateReq userCreateReq) {
         userRepository.findByEmail(userCreateReq.getEmail())
                 .ifPresent(() -> {throw new RuntimeException("user already exist!")});
         return userRepository.save(new User(
                 userCreateReq.getName(),
                 userCreateReq.getEmail(),
                 userCreateReq.getPassword(),
                 userCreateReq.getBirthday()
         ));
    }


    @Transactional
    public Optional<User> findPwMatchUser(String email, String password) {
        return userRepository.findByEmail(email)
                .map(user -> user.getPassword().equals(password) ? user : null);
    }
}
