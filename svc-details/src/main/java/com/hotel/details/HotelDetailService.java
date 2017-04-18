package com.hotel.details;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.hotel.proto.HotelDetails;

@Service
public class HotelDetailService {
    
    private static final Logger LOG = LoggerFactory.getLogger(HotelDetailService.class);

    private Map<Long, HotelDetails> detailsMap = new HashMap<>();
    private long delay = 0;
    private boolean enableFailures;
    
    public HotelDetails getHotelDetails(String hotelId) {
        LOG.info("detailsMap (size); " + detailsMap.size());
        HotelDetails details = detailsMap.get(Long.valueOf(hotelId));
        return details;
    }

    public void setDelay(long delay) {
        this.delay = delay;
        System.out.println("Delay (in secs) = " + (this.delay/1000));
    }
    
    public void toggleFailures() {
        this.enableFailures = this.enableFailures ? false : true;
    }
    
    @PostConstruct
    public void loadHotels() {
        HotelDetails.Builder hotelDetailsBuilder = HotelDetails.newBuilder();
        try (Stream<Path> stream = Files.list(Paths.get("./mock-data"))) {
            stream.forEach(path -> { 
                try {
                    String json = new String(Files.readAllBytes(path));
                    JsonFormat.parser().ignoringUnknownFields().merge(json, hotelDetailsBuilder.clear());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                HotelDetails details = hotelDetailsBuilder.build();
                detailsMap.put(details.getHotelId(), details);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
