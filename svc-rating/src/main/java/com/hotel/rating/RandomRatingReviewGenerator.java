package com.hotel.rating;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.hotel.reviews.proto.HotelReviewInfo;
import com.hotel.reviews.proto.Review;

@Component
public class RandomRatingReviewGenerator {
    
    private Random ratingRandom = new Random();
    private Random textRandom = new Random();
    private String[] randomText = {
            "sapien arcu sed augue aliquam erat volutpat in",
            "sem duis aliquam convallis nunc proin at turpis a",
            "lorem ipsum dolor sit amet",
            "luctus cum sociis natoque penatibus et magnis dis parturient montes",
            "natoque penatibus et magnis dis",
            "suspendisse potenti in eleifend quam a odio in",
            "in libero ut massa volutpat convallis morbi odio odio elementum",
            "eleifend donec ut dolor morbi vel",
            "tortor quis turpis sed ante vivamus tortor duis mattis egestas",
            "morbi quis tortor id nulla ultrices aliquet"
    };

    public HotelReviewInfo build(Long hotelId, int numOfReviews, boolean partial) {
        HotelReviewInfo.Builder reviewInfoBuilder = HotelReviewInfo.newBuilder();
        reviewInfoBuilder.setHotelId(hotelId);
        Double sumRating=0.0d;
        for (int i=1; i<=numOfReviews;i++) {
            int rating = ratingRandom.nextInt(6);
            sumRating += rating;
            if (!partial) {
                reviewInfoBuilder.addReviews(Review.newBuilder()
                        .setReviewId(1)
                        .setReviewRating(rating)
                        .setReviewText(randomText[textRandom.nextInt(10)])
                        .build());
            }
        }
        if (sumRating > 0) {
            Double avgRating = sumRating/numOfReviews;
            reviewInfoBuilder.setHotelReviewRating(avgRating);
        }
        return reviewInfoBuilder.build();
    }
    
    
}
