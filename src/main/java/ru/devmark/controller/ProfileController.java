package ru.devmark.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.devmark.model.Profile;
import ru.devmark.model.ProfileRequest;
import ru.devmark.service.ProfileService;

@RestController
@RequestMapping(value = "/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping(value = "/{personId:\\d+}")
    public Profile getProfile(@PathVariable int personId) {
        return profileService.getProfile(personId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody ProfileRequest request) {
        profileService.createProfile(
                request.firstName(),
                request.lastName(),
                request.age()
        );
    }

    @PutMapping(value = "/{personId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProfile(
            @Valid @RequestBody ProfileRequest request,
            @PathVariable int personId
    ) {
        profileService.updateProfile(
                request.firstName(),
                request.lastName(),
                request.age(),
                personId
        );
    }

    @DeleteMapping(value = "/{personId:\\d+}")
    public void deleteProfile(@PathVariable int personId) {
        profileService.deleteProfile(personId);
    }
}
