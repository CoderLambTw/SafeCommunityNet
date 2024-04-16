package com.youngwu.safecommunitynet.controller;

import com.youngwu.safecommunitynet.model.dto.SocialEventCreateDto;
import com.youngwu.safecommunitynet.model.dto.SocialEventUpdatedDto;
import com.youngwu.safecommunitynet.service.SocialEventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/9 3:24 PM
 * @description:
 */

@RestController
@RequestMapping("/api/socialEvent")
@AllArgsConstructor
public class SocialEventController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final SocialEventService socialEventService;


    @PostMapping
    public ResponseEntity<?> createSocialEvent(@RequestBody @Valid SocialEventCreateDto dto) {
        socialEventService.createSocialEvent(dto);
        logger.info("Social event created successfully");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllSocialEvents() {
        return ResponseEntity.ok(socialEventService.getAllSocialEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSocialEventById(@PathVariable Long id) {
        return ResponseEntity.ok(socialEventService.getSocialEventById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateSocialEvent(@RequestBody @Valid SocialEventUpdatedDto dto) {
        socialEventService.updateSocialEvent(dto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSocialEvent(@PathVariable Long id) {
        socialEventService.deleteSocialEvent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}
