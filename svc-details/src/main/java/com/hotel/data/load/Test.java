package com.hotel.data.load;

import java.io.FileReader;
import java.util.List;

import com.hotel.proto.Address;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

public class Test {

    public static void main(String[] args) throws Exception {
//        CSVReader reader = new CSVReader(new FileReader("./mock-data/ean_hotels.txt"));
//        ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
//        strat.setType(EANHotel.class);
//        String[] columns = new String[] {"EANHotelID","SequenceNumber","Name","Address1","Address2","City","StateProvince","PostalCode","Country","Latitude","Longitude","AirportCode",
//                                            "PropertyCategory","PropertyCurrency","StarRating","Confidence","SupplierType","Location","ChainCodeID","RegionID","HighRate","LowRate","CheckInTime","CheckOutTime"}; // the fields to bind do in your JavaBean
//        strat.setColumnMapping(columns);
//        CsvToBean<EANHotel> csv = new CsvToBean();
//        List<EANHotel> list = csv.parse(strat, reader, true);
//        list.forEach(hotel -> System.out.println(hotel.toString()));

        CSVReader reader = new CSVReader(new FileReader("./mock-data/addresses-lat-lon.txt"));
        ColumnPositionMappingStrategy<MockLocation> strat = new ColumnPositionMappingStrategy<>();
        strat.setType(MockLocation.class);
        String[] columns = new String[] {"streetAddress","city","stateCode","zipCode", "country", "phoneNumber", "latitude", "longitude"}; 
        strat.setColumnMapping(columns);
        CsvToBean<MockLocation> csv = new CsvToBean<>();
        List<MockLocation> list = csv.parse(strat, reader, true);
        list.forEach(hotel -> System.out.println(hotel.toString()));
    }

}
