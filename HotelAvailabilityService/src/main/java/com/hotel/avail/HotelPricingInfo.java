package com.hotel.avail;

public class HotelPricingInfo {

    private String hotelId;
    private Double price;
    private String availability;
    
    public HotelPricingInfo(String hotelId, Double price, String availability) {
        super();
        this.hotelId = hotelId;
        this.price = price;
        this.availability = availability;
    }

    public String getHotelId() {
        return hotelId;
    }

    public Double getPrice() {
        return price;
    }

    public String getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "HotelPricingInfo [hotelId=" + hotelId + ", price=" + price
                + ", availability=" + availability + "]";
    }
    
}
