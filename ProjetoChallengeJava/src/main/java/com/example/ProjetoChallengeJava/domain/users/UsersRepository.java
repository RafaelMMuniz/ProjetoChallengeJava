package com.example.ProjetoChallengeJava.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, String> {
    List<Users> findAllByActiveTrue();
}


