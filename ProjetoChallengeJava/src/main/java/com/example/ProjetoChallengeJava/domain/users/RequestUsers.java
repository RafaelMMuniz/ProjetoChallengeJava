package com.example.ProjetoChallengeJava.domain.users;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RequestUsers(String id, @NotNull String name) {
}
