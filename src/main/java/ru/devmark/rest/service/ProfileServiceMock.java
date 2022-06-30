package ru.devmark.rest.service;

import org.springframework.stereotype.Service;
import ru.devmark.rest.exception.ProfileNotFoundException;
import ru.devmark.rest.model.Profile;

@Service
public class ProfileServiceMock implements ProfileService {

    @Override
    public Profile getProfile(int personId) {
        // имитируем обращение к БД
        if (personId == 123) {
            return new Profile(
                    personId,
                    "Иван",
                    "Иванов"
            );
        } else {
            throw new ProfileNotFoundException(personId);
        }
    }
}
