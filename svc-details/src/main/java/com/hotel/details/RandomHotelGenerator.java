package com.hotel.details;

import java.io.FileReader;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.hotel.data.load.MockLocation;
import com.hotel.proto.Address;
import com.hotel.proto.Amenity;
import com.hotel.proto.Coordinates;
import com.hotel.proto.HotelDetails;
import com.hotel.proto.HotelsList;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

@Component
public class RandomHotelGenerator {
    
    private String[] chainCodes = {"HY","HL","BW", "CC", "CP", "CY", "DI", "FN", "FS", "HI"};
    private Random chainCodeRandom = new Random();
    private Random amenityRandom = new Random();
    private Random locationRandom = new Random();
    private List<MockLocation> mockLocations;
    
    @PostConstruct
    private void loadAddresses() throws Exception {
        CSVReader reader = new CSVReader(new FileReader("./mock-data/addresses-lat-lon.txt"));
        ColumnPositionMappingStrategy<MockLocation> strat = new ColumnPositionMappingStrategy<>();
        strat.setType(MockLocation.class);
        String[] columns = new String[] {"streetAddress","city","stateCode","zipCode", "country", "phoneNumber", "latitude", "longitude"}; 
        strat.setColumnMapping(columns);
        CsvToBean<MockLocation> csv = new CsvToBean<>();
        mockLocations = csv.parse(strat, reader, true);
    }

    public HotelDetails build(Long hotelId) throws Exception {
        HotelDetails.Builder hotelBuilder = HotelDetails.newBuilder();
        hotelBuilder.setHotelId(hotelId);
        hotelBuilder.setHotelName("Hotel" + hotelId);
        hotelBuilder.setHotelDescription("Hotel Description for " + hotelId);
        hotelBuilder.setChainCode(chainCodes[chainCodeRandom.nextInt(10)]);
        hotelBuilder.addAmenities(Amenity.forNumber(amenityRandom.nextInt(20))); 
        hotelBuilder.addAmenities(Amenity.forNumber(amenityRandom.nextInt(20)));
        hotelBuilder.addAmenities(Amenity.forNumber(amenityRandom.nextInt(20)));
        hotelBuilder.addAmenities(Amenity.forNumber(amenityRandom.nextInt(20)));
        hotelBuilder.addAmenities(Amenity.forNumber(amenityRandom.nextInt(20)));
        
        MockLocation randomLocation = mockLocations.get(locationRandom.nextInt(50));
        hotelBuilder.setCoordinates(Coordinates.newBuilder()
                                                .setLatitude(Double.valueOf(randomLocation.getLatitude().trim()))
                                                .setLongitude(Double.valueOf(randomLocation.getLongitude().trim()))
                                                .build());
        hotelBuilder.setAddress(Address.newBuilder()
                                        .setStreetAddress(randomLocation.getStreetAddress().trim())
                                        .setCity(randomLocation.getCity().trim())
                                        .setStateCode(randomLocation.getStateCode().trim())
                                        .setCountry("United States")
                                        .setCountryCode("US")
                                        .setZipCode(randomLocation.getZipCode())
                                        .build());
        return hotelBuilder.build();
    }
    
    public HotelsList build(int size) throws Exception {
        
        HotelsList.Builder listBuilder = HotelsList.newBuilder();
        for (long i=1;i<=size;) {
            listBuilder.addHotel(build(i++));
        }
        return listBuilder.build();
    }
}
