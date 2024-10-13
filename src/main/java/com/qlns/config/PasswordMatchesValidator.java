package com.qlns.config;

import com.qlns.model.Admin;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Admin admin = (Admin) value;
		return admin.getPassword().equals(admin.getMatchingPassword());
	}
}
