package com.hotel.model;

public class HotelShoppingInfo {
    private HotelDetails details;
    private HotelPricePreview pricePreview;
    private HotelReviewInfo reviewInfo;
    
    public HotelShoppingInfo(HotelDetails details, HotelPricePreview pricePreview, HotelReviewInfo reviewInfo) {
        super();
        this.details = details;
        this.pricePreview = pricePreview;
        this.reviewInfo = reviewInfo;
    }

    public HotelDetails getDetails() {
        return details;
    }

    public HotelPricePreview getPricePreview() {
        return pricePreview;
    }

    public HotelReviewInfo getReviewInfo() {
        return reviewInfo;
    }

    @Override
    public String toString() {
        return "HotelShoppingInfo [details=" + details + ", pricePreview=" + pricePreview + ", reviewInfo=" + reviewInfo
                + "]";
    }
    
}
