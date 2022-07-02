package ru.devmark.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import ru.devmark.exception.ProfileNotFoundException;
import ru.devmark.model.Profile;
import ru.devmark.repository.ProfileRepository;

@Primary
@Service
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public Profile getProfile(int personId) {
        return profileRepository.getProfileById(personId)
                .orElseThrow(() -> new ProfileNotFoundException(personId));
    }

    @Override
    public void createProfile(String firstName, String secondName, int age) {
        profileRepository.insertProfile(firstName, secondName, age);
    }

    @Override
    public void updateProfile(String firstName, String secondName, int age, int id) {
        var profile = profileRepository.getProfileById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
        profileRepository.updateProfile(firstName, secondName, age, profile.id());
    }

    @Override
    public void deleteProfile(int id) {
        var profile = profileRepository.getProfileById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
        profileRepository.deleteProfileById(profile.id());
    }
}
