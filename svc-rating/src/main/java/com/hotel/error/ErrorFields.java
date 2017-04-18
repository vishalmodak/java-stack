package com.hotel.error;

enum ErrorFields {
    ERROR("error"),
    MESSAGE("message"),
    TIMESTAMP("timestamp"),
    TRACE("trace"),
    STATUS("status"),
    EXCEPTION("exception"),
    PATH("path");
    
    private final String key;

    ErrorFields(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }
}
