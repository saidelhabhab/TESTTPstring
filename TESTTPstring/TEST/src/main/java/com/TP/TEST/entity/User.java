package com.TP.TEST.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private  String username;
    private  String password;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Authority> authoritySet;
}
