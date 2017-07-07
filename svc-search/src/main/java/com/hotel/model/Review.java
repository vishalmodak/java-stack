package com.hotel.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Review {
	@JsonProperty("reviewRating")
	private Integer reviewRating;
    @JsonProperty("reviewText")
    private String reviewText;
    @JsonProperty("reviewId")
    private Long reviewId;
    
 	public void setReviewrating(Integer reviewrating) {
		this.reviewRating = reviewrating;
	}

	public Integer getReviewrating() {
		return reviewRating;
	}

 	public void setReviewtext(String reviewtext) {
		this.reviewText = reviewtext;
	}

	public String getReviewtext() {
		return reviewText;
	}

 	public void setReviewid(Long reviewId) {
		this.reviewId = reviewId;
	}

	public Long getReviewId() {
		return reviewId;
	}

    @Override
    public String toString() {
        return "Review [reviewRating=" + reviewRating + ", reviewText=" + reviewText + ", reviewId=" + reviewId + "]";
    }

}