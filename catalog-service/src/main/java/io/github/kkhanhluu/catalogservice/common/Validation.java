package io.github.kkhanhluu.catalogservice.common;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;

public class Validation {

    private final static Validator validator = buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T object) {
        var violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
