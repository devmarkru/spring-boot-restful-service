package ru.devmark.model;

public record Profile(
        int id,
        String firstName,
        String lastName,
        int age
) {
}
