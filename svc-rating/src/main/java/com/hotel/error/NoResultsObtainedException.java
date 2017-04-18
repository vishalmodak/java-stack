package com.hotel.error;

public class NoResultsObtainedException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    
    public NoResultsObtainedException() { }

    public NoResultsObtainedException(String s) {
        super(s);
    }

    public NoResultsObtainedException(String message, Throwable cause) {
        super(message, cause);
    }
}
