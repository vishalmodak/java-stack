package com.hotel.details.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HotelDetails {
    private Long hotelId;
    private String hotelName;
    private String chainCode;
    private String description;
    private Set<Amenity> amenities;
    private int rating;
    private Address address;
    private Coordinates coord;

    public static HotelDetailsBuilder newBuilder() {
        return new HotelDetailsBuilder();
    }
    
    
    public Long getHotelId() {
        return hotelId;
    }


    public String getHotelName() {
        return hotelName;
    }


    public String getChainCode() {
        return chainCode;
    }


    public String getDescription() {
        return description;
    }


    public Set<Amenity> getAmenities() {
        return amenities;
    }


    public int getRating() {
        return rating;
    }


    public Address getAddress() {
        return address;
    }


    public Coordinates getCoord() {
        return coord;
    }


    public static class HotelDetailsBuilder {
        HotelDetails hotelDetails;
        
        public HotelDetailsBuilder() {
            hotelDetails = new HotelDetails();
        }
        
        public HotelDetailsBuilder setHotelId(Long hotelId) {
            hotelDetails.hotelId = hotelId;
            return this;
        }
        
        public HotelDetailsBuilder setHotelName(String name) {
            hotelDetails.hotelName = name;
            return this;
        }

        public HotelDetailsBuilder setChainCode(String code) {
            hotelDetails.chainCode = code;
            return this;
        }
        
        public HotelDetailsBuilder setDescription(String description) {
            hotelDetails.description = description;
            return this;
        }
        
        public HotelDetailsBuilder setRating(Integer rating) {
            hotelDetails.rating = rating;
            return this;
        }
        
        public HotelDetailsBuilder setAddress(Address address) {
            hotelDetails.address = address;
            return this;
        }

        public HotelDetailsBuilder setCoordinates(Coordinates coord) {
            hotelDetails.coord = coord;
            return this;
        }
        
        public HotelDetailsBuilder addAmenity(Amenity amenity) {
            if (hotelDetails.amenities == null) {
                hotelDetails.amenities = new HashSet<Amenity>();
            }
            hotelDetails.amenities.add(amenity);
            return this;
        }
        
        public HotelDetailsBuilder addAmenities(Amenity... amenities) {
            if (hotelDetails.amenities == null) {
                hotelDetails.amenities = new HashSet<Amenity>();
            }
            Collections.addAll(hotelDetails.amenities, amenities);
            return this;
        }
        
        public HotelDetails done() {
            return hotelDetails;
        }
    }
}
