package com.firstproject.phonebook.errors;

/**
 * @author StefanO (Stefan.Opariuc@tss-yonder.com)
 * @since 08.02.2017
 **/
public class ServerError extends CustomError {
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -8924891403612123307L;

    public ServerError(String defaultMessage) {
        super(defaultMessage);
    }
}