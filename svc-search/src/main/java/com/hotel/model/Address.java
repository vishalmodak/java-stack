package com.hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
	@JsonProperty("stateCode")
	private String statecode;
    @JsonProperty("city")
    private String city;
    @JsonProperty("streetAddress")
    private String streetaddress;
    @JsonProperty("countryCode")
    private String countrycode;
    @JsonProperty("zipCode")
    private String zipcode;
    @JsonProperty("country")
    private String country;
    
 	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}

	public String getStatecode() {
		return statecode;
	}

 	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

 	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getZipcode() {
		return zipcode;
	}

 	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

 	public void setStreetaddress(String streetaddress) {
		this.streetaddress = streetaddress;
	}

	public String getStreetaddress() {
		return streetaddress;
	}

 	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

    @Override
    public String toString() {
        return "Address [statecode=" + statecode + ", city=" + city + ", streetaddress=" + streetaddress
                + ", countrycode=" + countrycode + ", zipcode=" + zipcode + ", country=" + country + "]";
    }

}