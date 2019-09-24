package com.capco.challenge.entity;

import com.capco.challenge.enumeration.ProfileEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Setter
@Getter
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        @Column(unique = true)
        @Size(min = 1, max = 100)
        private String username;

        @Column(name = "profile")
        @Enumerated
        private ProfileEnum profile;

        @Column(name = "password")
        private String password;
}
