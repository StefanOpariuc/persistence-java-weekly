package com.firstproject.phonebook.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * @author StefanO (Stefan.Opariuc@tss-yonder.com)
 * @since 30.01.2017
 **/
public class TelephoneNumberValidator implements ConstraintValidator<TelephoneNumber, String> {

    public void initialize(TelephoneNumber constraintAnnotation) {
        //it's empty because we don't need to do anything here yet :)
        System.out.print("");
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.matches("^[0]{1}[0-9]{9}");
    }
}
