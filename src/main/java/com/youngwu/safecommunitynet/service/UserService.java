package com.youngwu.safecommunitynet.service;

import cn.hutool.core.bean.BeanUtil;
import com.youngwu.safecommunitynet.model.User;
import com.youngwu.safecommunitynet.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public User getUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public void updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id).get();

        BeanUtil.copyProperties(updatedUser, user);
        user.setId(id);

        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
