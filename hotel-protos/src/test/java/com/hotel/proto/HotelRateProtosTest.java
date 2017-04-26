package com.hotel.proto;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.google.protobuf.util.JsonFormat;
import com.hotel.rate.proto.Availability;
import com.hotel.rate.proto.DailyRate;
import com.hotel.rate.proto.HotelPriceInfo;
import com.hotel.rate.proto.HotelPricePreview;
import com.hotel.rate.proto.RateType;
import com.hotel.rate.proto.RoomRate;
import com.hotel.rate.proto.RoomType;

public class HotelRateProtosTest {

    @Test
    public void hotelPricePreviewSerialization() throws Exception {
        int hotelId = 1;
        HotelPricePreview shoppingInfo = HotelPricePreview.newBuilder()
                                                          .setHotelId(hotelId)
                                                          .setAvailabilityStatus(Availability.AVAILABLE)
                                                          .setDisplayPrice(100d)
                                                          .build();
        
        String fileName = "./src/test/data/pricePreview.json";
        Files.write(Paths.get(fileName), JsonFormat.printer().print(shoppingInfo).getBytes());
        
        HotelPricePreview.Builder builder = HotelPricePreview.newBuilder();
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        JsonFormat.parser().ignoringUnknownFields().merge(json, builder.clear());
        assertEquals(shoppingInfo, builder.build());
    }
    
    @Test
    public void hotelPriceInfoSerialization() throws Exception {
        int hotelId = 1;
        DailyRate dailyRate1 = DailyRate.newBuilder()
                                       .setBaseRate(80d)
                                       .setMarkup(16d)
                                       .setDiscount(1d)
                                       .build();
        RoomRate roomRate1 = RoomRate.newBuilder()
                                     .setRateType(RateType.STANDARD)
                                     .setRoomType(RoomType.ONE_KING)
                                     .addDailyRates(dailyRate1)
                                     .setRoomsAvailable(5)
                                     .build();
        HotelPriceInfo hotelPriceInfo = HotelPriceInfo.newBuilder()
                                                        .setHotelId(hotelId)
                                                        .setTotalPrice(100.00d)
                                                        .setTaxes(3.00d)
                                                        .setFees(2.00d)
                                                        .setTotalDiscount(5.00d)
                                                        .setAvgNightlyRate(97d)
                                                        .addRoomRates(roomRate1)
                                                        .build();
        
        String fileName = "./src/test/data/priceInfo.json";
        Files.write(Paths.get(fileName), JsonFormat.printer().print(hotelPriceInfo).getBytes());
        
        HotelPriceInfo.Builder builder = HotelPriceInfo.newBuilder();
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        JsonFormat.parser().ignoringUnknownFields().merge(json, builder.clear());
        assertEquals(hotelPriceInfo, builder.build());
    }
}

