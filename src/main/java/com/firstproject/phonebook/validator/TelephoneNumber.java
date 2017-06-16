package com.firstproject.phonebook.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author StefanO (Stefan.Opariuc@tss-yonder.com)
 * @since 30.01.2017
 **/
@Constraint(validatedBy = {TelephoneNumberValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface TelephoneNumber {
    String message() default "{validation.constraints.telephoneNUmber.message}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String value() default "";
}
