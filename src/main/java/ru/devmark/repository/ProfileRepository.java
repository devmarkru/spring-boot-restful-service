package ru.devmark.repository;

import ru.devmark.model.Profile;

import java.util.Optional;

public interface ProfileRepository {

    Optional<Profile> getProfileById(int id);
}
