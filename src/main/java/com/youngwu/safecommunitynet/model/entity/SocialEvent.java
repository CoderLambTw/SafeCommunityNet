package com.youngwu.safecommunitynet.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/1 2:32 PM
 * @description:
 */

@Entity
@Table(name = "social_events")
@Getter
@Setter
public class SocialEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private User user;

    @Column(name = "event_date")
    private Date eventDate;

    @Column(name = "event_time")
    private Time eventTime;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "location")
    private String location;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "description")
    private String description;
}
