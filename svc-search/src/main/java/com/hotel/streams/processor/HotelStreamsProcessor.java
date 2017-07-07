package com.hotel.streams.processor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import com.hotel.model.HotelDetails;
import com.hotel.model.HotelPricePreview;
import com.hotel.model.HotelReviewInfo;

@Component
public class HotelStreamsProcessor {
    
    private static final Logger LOG = LoggerFactory.getLogger(HotelStreamsProcessor.class);

    @Autowired
    private StreamsConfig streamsConfig;
    
    private KafkaStreams streams;
    
    @PostConstruct
    public void process() {
        KStreamBuilder builder = new KStreamBuilder();

        Serde<String> stringSerde = Serdes.String();
        
        JsonSerializer<HotelDetails> detailsJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<HotelDetails> detailsJsonDeserializer = new JsonDeserializer<>(HotelDetails.class);
        Serde<HotelDetails> detailsSerde = Serdes.serdeFrom(detailsJsonSerializer, detailsJsonDeserializer);

        JsonSerializer<HotelPricePreview> priceJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<HotelPricePreview> priceJsonDeserializer = new JsonDeserializer<>(HotelPricePreview.class);
        Serde<HotelPricePreview> priceSerde = Serdes.serdeFrom(priceJsonSerializer, priceJsonDeserializer);
        
        JsonSerializer<HotelReviewInfo> reviewJsonSerializer = new JsonSerializer<>();
        JsonDeserializer<HotelReviewInfo> reviewJsonDeserializer = new JsonDeserializer<>(HotelReviewInfo.class);
        Serde<HotelReviewInfo> reviewSerde = Serdes.serdeFrom(reviewJsonSerializer, reviewJsonDeserializer);
        
        KTable<String, HotelReviewInfo> reviewsTable = builder.table(stringSerde, reviewSerde, "hotel-reviews", "reviews");
        KTable<String, HotelDetails> detailsTable = builder.table(stringSerde, detailsSerde, "hotel-details", "details");
        KTable<String, HotelPricePreview> pricingTable = builder.table(stringSerde, priceSerde, "hotel-price", "pricing");
        
        streams = new KafkaStreams(builder, streamsConfig);
        streams.start();
    }
    
    @PreDestroy
    public void closeStream() {
        streams.close();
    }
}
