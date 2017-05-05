package com.hotel.data.load;

public class MockLocation {
    private String streetAddress;
    private String city;
    private String stateCode;
    private String zipCode;
    private String country;
    private String phoneNumber;
    private String latitude;
    private String longitude;
    
    public String getStreetAddress() {
        return streetAddress;
    }
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateCode() {
        return stateCode;
    }
    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getLatitude() {
        return latitude;
    }
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    public String getLongitude() {
        return longitude;
    }
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    @Override
    public String toString() {
        return "MockLocation [streetAddress=" + streetAddress + ", city=" + city + ", stateCode=" + stateCode
                + ", zipCode=" + zipCode + ", country=" + country + ", phoneNumber=" + phoneNumber + ", latitude="
                + latitude + ", longitude=" + longitude + "]";
    }
    
}
