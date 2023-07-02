package com.validationexceptionHandle.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserTypeValidator implements ConstraintValidator<ValidateUserType, String>{

	@Override
	public boolean isValid(String userType, ConstraintValidatorContext context) {
		
//		List<String> userTypes = Arrays.asList("Parmanent", "Temporary");
//		return userType.equalsIgnoreCase(userTypes.toString());
		Stream<String> validUserTypes = Stream.of("Permanent", "Temporary");
		return validUserTypes.anyMatch(type->type.equalsIgnoreCase(userType));
	}

	
}
