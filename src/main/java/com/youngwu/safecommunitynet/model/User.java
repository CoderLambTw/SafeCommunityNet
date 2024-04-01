package com.youngwu.safecommunitynet.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author: Young.Wu
 * @create-date: 2024/4/1 11:30 AM
 * @description:
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String email;
    private String password;

    @Column(name = "registration_date")
    private Date registrationDate;
}
