// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: reviews.proto

package com.hotel.reviews.proto;

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
    internal_static_com_hotel_reviews_proto_HotelReviewInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hotel_reviews_proto_HotelReviewInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_hotel_reviews_proto_Review_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_hotel_reviews_proto_Review_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\rreviews.proto\022\027com.hotel.reviews.proto" +
      "\"o\n\017HotelReviewInfo\022\017\n\007hotelId\030\001 \001(\003\022\031\n\021" +
      "hotelReviewRating\030\002 \001(\001\0220\n\007reviews\030\003 \003(\013" +
      "2\037.com.hotel.reviews.proto.Review\"D\n\006Rev" +
      "iew\022\020\n\010reviewId\030\001 \001(\003\022\024\n\014reviewRating\030\002 " +
      "\001(\003\022\022\n\nreviewText\030\003 \001(\tB\tB\005HotelP\001b\006prot" +
      "o3"
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
    internal_static_com_hotel_reviews_proto_HotelReviewInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_hotel_reviews_proto_HotelReviewInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hotel_reviews_proto_HotelReviewInfo_descriptor,
        new java.lang.String[] { "HotelId", "HotelReviewRating", "Reviews", });
    internal_static_com_hotel_reviews_proto_Review_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_com_hotel_reviews_proto_Review_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_hotel_reviews_proto_Review_descriptor,
        new java.lang.String[] { "ReviewId", "ReviewRating", "ReviewText", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}