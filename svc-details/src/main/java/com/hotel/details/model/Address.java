package com.hotel.details.model;

public class Address {
    private String street;
    private String city;
    private String state;
    private String stateCode;
    private String country;
    private String countryCode;
    private Integer zipCode;
    
    public static AddressBuilder newBuilder() {
        return new AddressBuilder();
    }
    
    public String getStreet() {
        return street;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public Integer getZipCode() {
        return zipCode;
    }
    
    public String getStateCode() {
        return stateCode;
    }
    public String getState() {
        return state;
    }
    public static class AddressBuilder {
        Address address;
        
        public AddressBuilder() {
            address = new Address();
        }
        
        public AddressBuilder setStreet(String street) {
            address.street = street;
            return this;
        }
        
        public AddressBuilder setCity(String city) {
            address.city = city;
            return this;
        }
        
        public AddressBuilder setCountry(String country) {
            address.country = country;
            return this;
        }
        
        public AddressBuilder setCountryCode(String countryCode) {
            address.countryCode = countryCode;
            return this;
        }
        
        public AddressBuilder setState(String state) {
            address.state = state;
            return this;
        }
        
        public AddressBuilder setStateCode(String stateCode) {
            address.stateCode = stateCode;
            return this;
        }
        
        public AddressBuilder setZipCode(Integer zipCode) {
            address.zipCode = zipCode;
            return this;
        }
        
        public Address done() {
            return address;
        }
    }
}
