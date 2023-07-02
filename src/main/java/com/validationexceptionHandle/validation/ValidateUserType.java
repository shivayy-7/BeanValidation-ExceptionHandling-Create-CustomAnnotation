package com.validationexceptionHandle.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserTypeValidator.class)
public @interface ValidateUserType {
	
	public String message()default "Invalid employeeType: It should be either Permanent or Temporary";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
