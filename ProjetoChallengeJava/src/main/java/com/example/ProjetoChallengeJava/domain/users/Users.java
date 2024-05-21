package com.example.ProjetoChallengeJava.domain.users;

import jakarta.persistence.*;
import lombok.*;

@Table(name="users")
@Entity(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Boolean active;

    public Users(RequestUsers requestUsers){
        this.name = requestUsers.name();
        this.active = true;
    }
}
