package com.youngwu.safecommunitynet.repository;

import com.youngwu.safecommunitynet.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/1 5:24 PM
 * @description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
