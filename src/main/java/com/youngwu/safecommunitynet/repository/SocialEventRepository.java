package com.youngwu.safecommunitynet.repository;

import com.youngwu.safecommunitynet.model.entity.SocialEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/9 4:11 PM
 * @description:
 */

@Repository
public interface SocialEventRepository extends JpaRepository<SocialEvent, Long> {
}
