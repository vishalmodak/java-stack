package com.hotel.proto;

import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.protobuf.util.JsonFormat;

public class HotelDetailsTest {

    public static void main(String[] args) throws Exception {
        HotelDetails details = HotelDetails.newBuilder()
                                            .setHotelName("Ziva")
                                            .setHotelId(1L)
                                            .setChainCode("HY")
                                            .setHotelDescription("blah")
                                            .setStarRating(4)
                                            .setAddress(Address.newBuilder()
                                                                .setStreetAddress("Paseo Malecón Sn Lote 5")
                                                                .setCity("San Jose del Cabo")
                                                                .setCountry("Mexico")
                                                                .setZipCode("23405")
                                                                .build())
                                            .addAmenities(Amenity.WIFI)
                                            .addAmenities(Amenity.FITNESS_CENTER)
                                            .addAmenities(Amenity.HOT_TUB)
                                            .setCoordinates(Coordinates.newBuilder().setLatitude(23.042353d).setLongitude(-109.7040867d).build())
                                            .build();
        System.out.println(JsonFormat.printer().print(details));
        
        HotelDetails.Builder builder = HotelDetails.newBuilder();
        String json = new String(Files.readAllBytes(Paths.get("hotel1.json")));
        JsonFormat.parser().ignoringUnknownFields().merge(json, builder.clear());
        System.out.println(builder.build().toString());
    }
}
