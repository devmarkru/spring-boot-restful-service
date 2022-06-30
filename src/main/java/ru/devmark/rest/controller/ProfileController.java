package ru.devmark.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.devmark.rest.model.Profile;
import ru.devmark.rest.service.ProfileService;

@RestController
@RequestMapping(value = "/profile")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{personId:\\d+}")
    public Profile getProfile(@PathVariable int personId) {
        return profileService.getProfile(personId);
    }
}
