package com.gabrielgua.shelfie.api.validation.validators;

import com.gabrielgua.shelfie.api.validation.annotations.NonZero;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NonZeroValidator implements ConstraintValidator<NonZero, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        return value != 0;
    }
}