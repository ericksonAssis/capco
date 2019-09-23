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

        @NotBlank
        @Size(max = 50)
        @Column(name = "first_name")
        private String firstName;

        @Size(max = 50)
        @Column(name = "last_name")
        private String lastName;

        @Column(name = "profile")
        private ProfileEnum profile;
}
