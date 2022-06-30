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
}
