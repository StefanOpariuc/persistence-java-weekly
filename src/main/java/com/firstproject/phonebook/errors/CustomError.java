package com.firstproject.phonebook.errors;

import java.text.MessageFormat;

/**
 * @author StefanO (Stefan.Opariuc@tss-yonder.com)
 * @since 08.02.2017
 **/
public class CustomError extends RuntimeException {

    private static final long serialVersionUID = -8924891403782123307L;


    public CustomError(String defaultMessage) {
        super(MessageFormat.format(defaultMessage, null), null);
    }
}
