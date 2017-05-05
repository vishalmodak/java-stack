package com.hotel.proto;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;


public class HotelProtosTest {

    @Test
    public void jsonSerialization() throws Exception {
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
        String fileName = "./src/test/data/hotel.json";
        Files.write(Paths.get(fileName), JsonFormat.printer().print(details).getBytes());
        
        HotelDetails.Builder builder = HotelDetails.newBuilder();
        String json = new String(Files.readAllBytes(Paths.get(fileName)));
        JsonFormat.parser().ignoringUnknownFields().merge(json, builder.clear());
        assertEquals(details, builder.build());
    }
    
    @Test
    public void addressSerialization() throws InvalidProtocolBufferException, IOException {
        Address address = Address.newBuilder()
                .setStreetAddress("Paseo Malecón Sn Lote 5")
                .setCity("San Jose del Cabo")
                .setState("Blah")
                .setStateCode("UH")
                .setCountry("Mexico")
                .setCountryCode("MX")
                .setZipCode("23405")
                .build();
        String fileName = "./src/test/data/address.json";
        Files.write(Paths.get(fileName), JsonFormat.printer().print(address).getBytes());
    }
}
