// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hotel.proto

package com.hotel.proto;

public final class Hotel {
  private Hotel() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hotel_proto_HotelDetails_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hotel_proto_HotelDetails_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hotel_proto_Address_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hotel_proto_Address_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hotel_proto_Coordinates_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hotel_proto_Coordinates_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013hotel.proto\022\017com.hotel.proto\"\376\001\n\014Hotel" +
      "Details\022\017\n\007hotelId\030\001 \001(\003\022\021\n\thotelName\030\002 " +
      "\001(\t\022\030\n\020hotelDescription\030\003 \001(\t\022\021\n\tchainCo" +
      "de\030\004 \001(\t\022\022\n\nstarRating\030\005 \001(\003\022)\n\007address\030" +
      "\006 \001(\0132\030.com.hotel.proto.Address\0221\n\013coord" +
      "inates\030\007 \001(\0132\034.com.hotel.proto.Coordinat" +
      "es\022+\n\tamenities\030\010 \003(\0162\030.com.hotel.proto." +
      "Amenity\"\207\001\n\007Address\022\025\n\rstreetAddress\030\001 \001" +
      "(\t\022\014\n\004city\030\002 \001(\t\022\r\n\005state\030\003 \001(\t\022\021\n\tstate" +
      "Code\030\004 \001(\t\022\017\n\007country\030\005 \001(\t\022\023\n\013countryCo",
      "de\030\006 \001(\t\022\017\n\007zipCode\030\007 \001(\t\"2\n\013Coordinates" +
      "\022\020\n\010latitude\030\001 \001(\001\022\021\n\tlongitude\030\002 \001(\001*\314\001" +
      "\n\007Amenity\022\010\n\004WIFI\020\000\022\027\n\023HIGH_SPEED_INTERN" +
      "ET\020\001\022\010\n\004POOL\020\002\022\013\n\007HOT_TUB\020\003\022\013\n\007JACUZZI\020\004" +
      "\022\016\n\nRESTAURANT\020\005\022\022\n\016FITNESS_CENTER\020\006\022\013\n\007" +
      "LAUNDRY\020\007\022\020\n\014ROOM_SERVICE\020\010\022\n\n\006CASINO\020\t\022" +
      "\020\n\014FREE_PARKING\020\n\022\007\n\003SPA\020\013\022\020\n\014PET_FRIEND" +
      "LY\020\014B\tB\005HotelP\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_hotel_proto_HotelDetails_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_hotel_proto_HotelDetails_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hotel_proto_HotelDetails_descriptor,
        new java.lang.String[] { "HotelId", "HotelName", "HotelDescription", "ChainCode", "StarRating", "Address", "Coordinates", "Amenities", });
    internal_static_com_hotel_proto_Address_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_hotel_proto_Address_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hotel_proto_Address_descriptor,
        new java.lang.String[] { "StreetAddress", "City", "State", "StateCode", "Country", "CountryCode", "ZipCode", });
    internal_static_com_hotel_proto_Coordinates_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_com_hotel_proto_Coordinates_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hotel_proto_Coordinates_descriptor,
        new java.lang.String[] { "Latitude", "Longitude", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}