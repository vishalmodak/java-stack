// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hotel.proto

package com.hotel.proto;

public interface HotelDetailsOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.hotel.proto.HotelDetails)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>optional int64 hotelId = 1;</code>
   */
  boolean hasHotelId();
  /**
   * <code>optional int64 hotelId = 1;</code>
   */
  long getHotelId();

  /**
   * <code>optional string hotelName = 2;</code>
   */
  boolean hasHotelName();
  /**
   * <code>optional string hotelName = 2;</code>
   */
  java.lang.String getHotelName();
  /**
   * <code>optional string hotelName = 2;</code>
   */
  com.google.protobuf.ByteString
      getHotelNameBytes();

  /**
   * <code>optional string hotelDescription = 3;</code>
   */
  boolean hasHotelDescription();
  /**
   * <code>optional string hotelDescription = 3;</code>
   */
  java.lang.String getHotelDescription();
  /**
   * <code>optional string hotelDescription = 3;</code>
   */
  com.google.protobuf.ByteString
      getHotelDescriptionBytes();

  /**
   * <code>optional string chainCode = 4;</code>
   */
  boolean hasChainCode();
  /**
   * <code>optional string chainCode = 4;</code>
   */
  java.lang.String getChainCode();
  /**
   * <code>optional string chainCode = 4;</code>
   */
  com.google.protobuf.ByteString
      getChainCodeBytes();

  /**
   * <code>optional int64 starRating = 5;</code>
   */
  boolean hasStarRating();
  /**
   * <code>optional int64 starRating = 5;</code>
   */
  long getStarRating();

  /**
   * <code>optional .com.hotel.proto.Address address = 6;</code>
   */
  boolean hasAddress();
  /**
   * <code>optional .com.hotel.proto.Address address = 6;</code>
   */
  com.hotel.proto.Address getAddress();
  /**
   * <code>optional .com.hotel.proto.Address address = 6;</code>
   */
  com.hotel.proto.AddressOrBuilder getAddressOrBuilder();

  /**
   * <code>optional .com.hotel.proto.Coordinates coordinates = 7;</code>
   */
  boolean hasCoordinates();
  /**
   * <code>optional .com.hotel.proto.Coordinates coordinates = 7;</code>
   */
  com.hotel.proto.Coordinates getCoordinates();
  /**
   * <code>optional .com.hotel.proto.Coordinates coordinates = 7;</code>
   */
  com.hotel.proto.CoordinatesOrBuilder getCoordinatesOrBuilder();

  /**
   * <code>repeated .com.hotel.proto.Amenity amenities = 8;</code>
   */
  java.util.List<com.hotel.proto.Amenity> getAmenitiesList();
  /**
   * <code>repeated .com.hotel.proto.Amenity amenities = 8;</code>
   */
  int getAmenitiesCount();
  /**
   * <code>repeated .com.hotel.proto.Amenity amenities = 8;</code>
   */
  com.hotel.proto.Amenity getAmenities(int index);
}