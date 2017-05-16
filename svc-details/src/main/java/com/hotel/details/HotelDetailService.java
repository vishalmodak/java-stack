package com.hotel.details;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.protobuf.util.JsonFormat;
import com.hotel.proto.HotelDetails;
import com.hotel.proto.HotelsList;

@Service
public class HotelDetailService {
    
    private static final Logger LOG = LoggerFactory.getLogger(HotelDetailService.class);
    
    @Autowired
    private RandomHotelGenerator hotelGenerator;
    
    private Map<Long, HotelDetails> detailsMap = new HashMap<>();
    private Random latencyDelay = new Random();
    
    public HotelDetails getHotelDetails(Long hotelId) throws Exception {
        Thread.sleep(latencyDelay.nextInt(5000));
        return hotelGenerator.build(hotelId);
    }

    public HotelsList getHotelList(int pageSize) throws Exception {
        Thread.sleep(latencyDelay.nextInt(5000));
        return hotelGenerator.build(pageSize);
    }
    
//    @PostConstruct
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
