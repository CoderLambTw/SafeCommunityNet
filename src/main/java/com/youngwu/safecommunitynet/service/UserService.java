package com.youngwu.safecommunitynet.service;

import cn.hutool.core.bean.BeanUtil;
import com.youngwu.safecommunitynet.exception.UserNotFoundException;
import com.youngwu.safecommunitynet.model.User;
import com.youngwu.safecommunitynet.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/1 5:19 PM
 * @description:
 */
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserId(Long id) {
        return userRepository.findById(id)
                             .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));
    }

    public void updateUser(Long id, User updatedUser) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            BeanUtil.copyProperties(updatedUser, user);
            user.setId(id);
            userRepository.save(user);
        } else {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }
    }

    public void deleteUser(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("User with id: " + id + " not found");
        }
    }
}
