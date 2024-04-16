package com.youngwu.safecommunitynet.service;

import cn.hutool.core.bean.BeanUtil;
import com.youngwu.safecommunitynet.exception.DataNotFoundException;
import com.youngwu.safecommunitynet.model.dto.SocialEventCreateDto;
import com.youngwu.safecommunitynet.model.dto.SocialEventUpdatedDto;
import com.youngwu.safecommunitynet.model.entity.SocialEvent;
import com.youngwu.safecommunitynet.model.entity.User;
import com.youngwu.safecommunitynet.repository.SocialEventRepository;
import com.youngwu.safecommunitynet.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/9 4:14 PM
 * @description:
 */

@AllArgsConstructor
@Service
public class SocialEventService {

    private static final Logger logger = LoggerFactory.getLogger(SocialEventService.class);

    private final UserRepository userRepository;

    private final SocialEventRepository socialEventRepository;

    public void createSocialEvent(SocialEventCreateDto dto) {
        logger.debug("Creating social event from DTO {}", dto);

        Long userId = dto.getUserId();

        User user = getUser(userId);
        SocialEvent socialEvent = new SocialEvent();
        BeanUtil.copyProperties(dto, socialEvent);
        socialEvent.setUser(user);

        socialEventRepository.save(socialEvent);

        logger.info("Social event created");
    }

    public List<SocialEvent> getAllSocialEvents() {
        logger.debug("Getting all social events");
        return socialEventRepository.findAll();
    }

    private User getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new DataNotFoundException("User with id: " + userId + " not found"));
    }

    public SocialEvent getSocialEventById(Long id) {
        logger.debug("Getting social event with id {}", id);

        return socialEventRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Social event with id: " + id + " not found"));
    }

    public void updateSocialEvent(SocialEventUpdatedDto dto) {
        logger.debug("Updating social event from DTO {}", dto);

        Long socialEventId = dto.getId();
        Long userId = dto.getUserId();

        Optional<SocialEvent> optionalSocialEvent = socialEventRepository.findById(socialEventId);
        if (optionalSocialEvent.isPresent()) {
            User user = getUser(userId);
            SocialEvent socialEvent = new SocialEvent();
            BeanUtil.copyProperties(dto, socialEvent);
            socialEvent.setUser(user);
            socialEventRepository.save(socialEvent);
        } else {
            logger.error("Social event with id {} not found", socialEventId);
            throw new DataNotFoundException("Social event with id: " + socialEventId + " not found");
        }
        logger.info("Social event with id: {} updated", socialEventId);
    }

    public void deleteSocialEvent(Long id) {
        logger.debug("Deleting social event with id {}", id);

        Optional<SocialEvent> optionalSocialEvent = socialEventRepository.findById(id);
        if (optionalSocialEvent.isPresent()) {
            socialEventRepository.deleteById(id);
        } else {
            logger.error("Social event with id {} not found", id);
            throw new DataNotFoundException("Social event with id: " + id + " not found");
        }
        logger.info("Social event with id: {} deleted", id);
    }
}
