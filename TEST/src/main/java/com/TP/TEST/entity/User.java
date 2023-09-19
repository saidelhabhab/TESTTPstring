package com.TP.TEST.entity;


import jakarta.persistence.*;
import lombok.*;

@Data@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    private  String username;
    private  String password;
}
