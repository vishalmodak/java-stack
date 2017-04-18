package com.hotel.pricing.model;

import java.util.List;

public class HotelPricingInfo {
    private Long hotelId;
    private Double totalPrice;
    private Double taxes;
    private Double fees;
    private Double totalDiscount;
    private List<Rate> rates;

}
