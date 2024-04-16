package com.youngwu.safecommunitynet.service;

import cn.hutool.core.bean.BeanUtil;
import com.youngwu.safecommunitynet.exception.DataNotFoundException;
import com.youngwu.safecommunitynet.model.dto.UserCreateDto;
import com.youngwu.safecommunitynet.model.dto.UserUpdatedDto;
import com.youngwu.safecommunitynet.model.entity.User;
import com.youngwu.safecommunitynet.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public void createUser(UserCreateDto dto) {
        logger.info("Creating user {}", dto.getUsername());

        User user = new User();
        BeanUtil.copyProperties(dto, user);
        userRepository.save(user);
        logger.info("User {} created", dto.getUsername());
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUserId(Long id) {
        logger.debug("Getting user with id {}", id);

        return userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + id + " not found"));
    }

    public void updateUser(UserUpdatedDto dto) {
        logger.debug("Updating user from DTO {}", dto);

        Long id = dto.getId();
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            BeanUtil.copyProperties(dto, user);
            user.setId(id);
            userRepository.save(user);
        } else {
            logger.error("User with id: {} not found", id);
            throw new DataNotFoundException("User with id: " + id + " not found");
        }
        logger.info("User with id: {} updated", id);
    }

    public void deleteUser(Long id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
        } else {
            throw new DataNotFoundException("User with id: " + id + " not found");
        }
    }
}
