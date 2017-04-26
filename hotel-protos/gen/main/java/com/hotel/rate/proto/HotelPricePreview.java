// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: hotel_rate.proto

package com.hotel.rate.proto;

/**
 * Protobuf type {@code com.hotel.rate.proto.HotelPricePreview}
 */
public  final class HotelPricePreview extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.hotel.rate.proto.HotelPricePreview)
    HotelPricePreviewOrBuilder {
  // Use HotelPricePreview.newBuilder() to construct.
  private HotelPricePreview(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HotelPricePreview() {
    hotelId_ = 0L;
    availabilityStatus_ = 0;
    displayPrice_ = 0D;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private HotelPricePreview(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            hotelId_ = input.readInt64();
            break;
          }
          case 16: {
            int rawValue = input.readEnum();

            availabilityStatus_ = rawValue;
            break;
          }
          case 25: {

            displayPrice_ = input.readDouble();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.hotel.rate.proto.Hotel.internal_static_com_hotel_rate_proto_HotelPricePreview_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.hotel.rate.proto.Hotel.internal_static_com_hotel_rate_proto_HotelPricePreview_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.hotel.rate.proto.HotelPricePreview.class, com.hotel.rate.proto.HotelPricePreview.Builder.class);
  }

  public static final int HOTELID_FIELD_NUMBER = 1;
  private long hotelId_;
  /**
   * <code>int64 hotelId = 1;</code>
   */
  public long getHotelId() {
    return hotelId_;
  }

  public static final int AVAILABILITYSTATUS_FIELD_NUMBER = 2;
  private int availabilityStatus_;
  /**
   * <code>.com.hotel.rate.proto.Availability availabilityStatus = 2;</code>
   */
  public int getAvailabilityStatusValue() {
    return availabilityStatus_;
  }
  /**
   * <code>.com.hotel.rate.proto.Availability availabilityStatus = 2;</code>
   */
  public com.hotel.rate.proto.Availability getAvailabilityStatus() {
    com.hotel.rate.proto.Availability result = com.hotel.rate.proto.Availability.valueOf(availabilityStatus_);
    return result == null ? com.hotel.rate.proto.Availability.UNRECOGNIZED : result;
  }

  public static final int DISPLAYPRICE_FIELD_NUMBER = 3;
  private double displayPrice_;
  /**
   * <code>double displayPrice = 3;</code>
   */
  public double getDisplayPrice() {
    return displayPrice_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (hotelId_ != 0L) {
      output.writeInt64(1, hotelId_);
    }
    if (availabilityStatus_ != com.hotel.rate.proto.Availability.AVAILABLE.getNumber()) {
      output.writeEnum(2, availabilityStatus_);
    }
    if (displayPrice_ != 0D) {
      output.writeDouble(3, displayPrice_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (hotelId_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, hotelId_);
    }
    if (availabilityStatus_ != com.hotel.rate.proto.Availability.AVAILABLE.getNumber()) {
      size += com.google.protobuf.CodedOutputStream
        .computeEnumSize(2, availabilityStatus_);
    }
    if (displayPrice_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(3, displayPrice_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.hotel.rate.proto.HotelPricePreview)) {
      return super.equals(obj);
    }
    com.hotel.rate.proto.HotelPricePreview other = (com.hotel.rate.proto.HotelPricePreview) obj;

    boolean result = true;
    result = result && (getHotelId()
        == other.getHotelId());
    result = result && availabilityStatus_ == other.availabilityStatus_;
    result = result && (
        java.lang.Double.doubleToLongBits(getDisplayPrice())
        == java.lang.Double.doubleToLongBits(
            other.getDisplayPrice()));
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + HOTELID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getHotelId());
    hash = (37 * hash) + AVAILABILITYSTATUS_FIELD_NUMBER;
    hash = (53 * hash) + availabilityStatus_;
    hash = (37 * hash) + DISPLAYPRICE_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getDisplayPrice()));
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.hotel.rate.proto.HotelPricePreview parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.hotel.rate.proto.HotelPricePreview parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.hotel.rate.proto.HotelPricePreview prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code com.hotel.rate.proto.HotelPricePreview}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.hotel.rate.proto.HotelPricePreview)
      com.hotel.rate.proto.HotelPricePreviewOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.hotel.rate.proto.Hotel.internal_static_com_hotel_rate_proto_HotelPricePreview_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.hotel.rate.proto.Hotel.internal_static_com_hotel_rate_proto_HotelPricePreview_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.hotel.rate.proto.HotelPricePreview.class, com.hotel.rate.proto.HotelPricePreview.Builder.class);
    }

    // Construct using com.hotel.rate.proto.HotelPricePreview.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      hotelId_ = 0L;

      availabilityStatus_ = 0;

      displayPrice_ = 0D;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.hotel.rate.proto.Hotel.internal_static_com_hotel_rate_proto_HotelPricePreview_descriptor;
    }

    public com.hotel.rate.proto.HotelPricePreview getDefaultInstanceForType() {
      return com.hotel.rate.proto.HotelPricePreview.getDefaultInstance();
    }

    public com.hotel.rate.proto.HotelPricePreview build() {
      com.hotel.rate.proto.HotelPricePreview result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.hotel.rate.proto.HotelPricePreview buildPartial() {
      com.hotel.rate.proto.HotelPricePreview result = new com.hotel.rate.proto.HotelPricePreview(this);
      result.hotelId_ = hotelId_;
      result.availabilityStatus_ = availabilityStatus_;
      result.displayPrice_ = displayPrice_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.hotel.rate.proto.HotelPricePreview) {
        return mergeFrom((com.hotel.rate.proto.HotelPricePreview)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.hotel.rate.proto.HotelPricePreview other) {
      if (other == com.hotel.rate.proto.HotelPricePreview.getDefaultInstance()) return this;
      if (other.getHotelId() != 0L) {
        setHotelId(other.getHotelId());
      }
      if (other.availabilityStatus_ != 0) {
        setAvailabilityStatusValue(other.getAvailabilityStatusValue());
      }
      if (other.getDisplayPrice() != 0D) {
        setDisplayPrice(other.getDisplayPrice());
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.hotel.rate.proto.HotelPricePreview parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.hotel.rate.proto.HotelPricePreview) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long hotelId_ ;
    /**
     * <code>int64 hotelId = 1;</code>
     */
    public long getHotelId() {
      return hotelId_;
    }
    /**
     * <code>int64 hotelId = 1;</code>
     */
    public Builder setHotelId(long value) {
      
      hotelId_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int64 hotelId = 1;</code>
     */
    public Builder clearHotelId() {
      
      hotelId_ = 0L;
      onChanged();
      return this;
    }

    private int availabilityStatus_ = 0;
    /**
     * <code>.com.hotel.rate.proto.Availability availabilityStatus = 2;</code>
     */
    public int getAvailabilityStatusValue() {
      return availabilityStatus_;
    }
    /**
     * <code>.com.hotel.rate.proto.Availability availabilityStatus = 2;</code>
     */
    public Builder setAvailabilityStatusValue(int value) {
      availabilityStatus_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>.com.hotel.rate.proto.Availability availabilityStatus = 2;</code>
     */
    public com.hotel.rate.proto.Availability getAvailabilityStatus() {
      com.hotel.rate.proto.Availability result = com.hotel.rate.proto.Availability.valueOf(availabilityStatus_);
      return result == null ? com.hotel.rate.proto.Availability.UNRECOGNIZED : result;
    }
    /**
     * <code>.com.hotel.rate.proto.Availability availabilityStatus = 2;</code>
     */
    public Builder setAvailabilityStatus(com.hotel.rate.proto.Availability value) {
      if (value == null) {
        throw new NullPointerException();
      }
      
      availabilityStatus_ = value.getNumber();
      onChanged();
      return this;
    }
    /**
     * <code>.com.hotel.rate.proto.Availability availabilityStatus = 2;</code>
     */
    public Builder clearAvailabilityStatus() {
      
      availabilityStatus_ = 0;
      onChanged();
      return this;
    }

    private double displayPrice_ ;
    /**
     * <code>double displayPrice = 3;</code>
     */
    public double getDisplayPrice() {
      return displayPrice_;
    }
    /**
     * <code>double displayPrice = 3;</code>
     */
    public Builder setDisplayPrice(double value) {
      
      displayPrice_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double displayPrice = 3;</code>
     */
    public Builder clearDisplayPrice() {
      
      displayPrice_ = 0D;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.hotel.rate.proto.HotelPricePreview)
  }

  // @@protoc_insertion_point(class_scope:com.hotel.rate.proto.HotelPricePreview)
  private static final com.hotel.rate.proto.HotelPricePreview DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.hotel.rate.proto.HotelPricePreview();
  }

  public static com.hotel.rate.proto.HotelPricePreview getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HotelPricePreview>
      PARSER = new com.google.protobuf.AbstractParser<HotelPricePreview>() {
    public HotelPricePreview parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new HotelPricePreview(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HotelPricePreview> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HotelPricePreview> getParserForType() {
    return PARSER;
  }

  public com.hotel.rate.proto.HotelPricePreview getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

