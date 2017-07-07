package com.hotel.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelReviewInfo {
	@JsonProperty("hotelId")
	private String hotelid;
    @JsonProperty("hotelReviewRating")
    private Double hotelreviewrating;
    @JsonProperty("reviews")
    private List<Review> reviews;
    
 	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}

	public String getHotelid() {
		return hotelid;
	}

 	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Review> getReviews() {
		return reviews;
	}

 	public void setHotelreviewrating(Double hotelreviewrating) {
		this.hotelreviewrating = hotelreviewrating;
	}

	public Double getHotelreviewrating() {
		return hotelreviewrating;
	}

    @Override
    public String toString() {
        return "HotelReviewInfo [hotelid=" + hotelid + ", hotelreviewrating=" + hotelreviewrating + ", reviews="
                + reviews + "]";
    }

}