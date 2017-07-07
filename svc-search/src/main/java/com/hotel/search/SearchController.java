package com.hotel.search;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.apache.kafka.streams.state.Stores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.model.HotelDetails;
import com.hotel.model.HotelShoppingInfo;

@RestController
public class SearchController {
    
    private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);
    
    @Autowired
    private StreamsConfig streamsConfig;
    
    @RequestMapping(value = "/hotel/search/{hotelId}", method = RequestMethod.GET)
    public HotelShoppingInfo search(@PathVariable String hotelId) {
        KStreamBuilder builder = new KStreamBuilder();
        KafkaStreams streams = new KafkaStreams(builder, streamsConfig);
        final ReadOnlyKeyValueStore<String, HotelDetails> detailsStore = (ReadOnlyKeyValueStore<String, HotelDetails>)
                streams.store("details", QueryableStoreTypes.<String, HotelDetails>keyValueStore());
        
        return new HotelShoppingInfo(detailsStore.get(hotelId), null, null);

    }
}
