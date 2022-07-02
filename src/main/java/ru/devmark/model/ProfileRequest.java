package ru.devmark.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public record ProfileRequest(
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        @NotNull
        @Min(1)
        Integer age
) {
}
