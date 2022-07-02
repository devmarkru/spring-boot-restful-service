package ru.devmark.service;

import ru.devmark.model.Profile;

public interface ProfileService {

    Profile getProfile(int personId);

    void createProfile(String firstName, String secondName, int age);

    void updateProfile(String firstName, String secondName, int age, int id);

    void deleteProfile(int id);
}
