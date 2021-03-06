// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: reviews.proto

package com.hotel.reviews.proto;

/**
 * Protobuf type {@code com.hotel.reviews.proto.HotelReviewInfo}
 */
public  final class HotelReviewInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:com.hotel.reviews.proto.HotelReviewInfo)
    HotelReviewInfoOrBuilder {
  // Use HotelReviewInfo.newBuilder() to construct.
  private HotelReviewInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private HotelReviewInfo() {
    hotelId_ = 0L;
    hotelReviewRating_ = 0D;
    reviews_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private HotelReviewInfo(
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
          case 17: {

            hotelReviewRating_ = input.readDouble();
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              reviews_ = new java.util.ArrayList<com.hotel.reviews.proto.Review>();
              mutable_bitField0_ |= 0x00000004;
            }
            reviews_.add(
                input.readMessage(com.hotel.reviews.proto.Review.parser(), extensionRegistry));
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
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        reviews_ = java.util.Collections.unmodifiableList(reviews_);
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.hotel.reviews.proto.Hotel.internal_static_com_hotel_reviews_proto_HotelReviewInfo_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.hotel.reviews.proto.Hotel.internal_static_com_hotel_reviews_proto_HotelReviewInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.hotel.reviews.proto.HotelReviewInfo.class, com.hotel.reviews.proto.HotelReviewInfo.Builder.class);
  }

  private int bitField0_;
  public static final int HOTELID_FIELD_NUMBER = 1;
  private long hotelId_;
  /**
   * <code>int64 hotelId = 1;</code>
   */
  public long getHotelId() {
    return hotelId_;
  }

  public static final int HOTELREVIEWRATING_FIELD_NUMBER = 2;
  private double hotelReviewRating_;
  /**
   * <code>double hotelReviewRating = 2;</code>
   */
  public double getHotelReviewRating() {
    return hotelReviewRating_;
  }

  public static final int REVIEWS_FIELD_NUMBER = 3;
  private java.util.List<com.hotel.reviews.proto.Review> reviews_;
  /**
   * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
   */
  public java.util.List<com.hotel.reviews.proto.Review> getReviewsList() {
    return reviews_;
  }
  /**
   * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
   */
  public java.util.List<? extends com.hotel.reviews.proto.ReviewOrBuilder> 
      getReviewsOrBuilderList() {
    return reviews_;
  }
  /**
   * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
   */
  public int getReviewsCount() {
    return reviews_.size();
  }
  /**
   * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
   */
  public com.hotel.reviews.proto.Review getReviews(int index) {
    return reviews_.get(index);
  }
  /**
   * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
   */
  public com.hotel.reviews.proto.ReviewOrBuilder getReviewsOrBuilder(
      int index) {
    return reviews_.get(index);
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
    if (hotelReviewRating_ != 0D) {
      output.writeDouble(2, hotelReviewRating_);
    }
    for (int i = 0; i < reviews_.size(); i++) {
      output.writeMessage(3, reviews_.get(i));
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
    if (hotelReviewRating_ != 0D) {
      size += com.google.protobuf.CodedOutputStream
        .computeDoubleSize(2, hotelReviewRating_);
    }
    for (int i = 0; i < reviews_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, reviews_.get(i));
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
    if (!(obj instanceof com.hotel.reviews.proto.HotelReviewInfo)) {
      return super.equals(obj);
    }
    com.hotel.reviews.proto.HotelReviewInfo other = (com.hotel.reviews.proto.HotelReviewInfo) obj;

    boolean result = true;
    result = result && (getHotelId()
        == other.getHotelId());
    result = result && (
        java.lang.Double.doubleToLongBits(getHotelReviewRating())
        == java.lang.Double.doubleToLongBits(
            other.getHotelReviewRating()));
    result = result && getReviewsList()
        .equals(other.getReviewsList());
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
    hash = (37 * hash) + HOTELREVIEWRATING_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        java.lang.Double.doubleToLongBits(getHotelReviewRating()));
    if (getReviewsCount() > 0) {
      hash = (37 * hash) + REVIEWS_FIELD_NUMBER;
      hash = (53 * hash) + getReviewsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.hotel.reviews.proto.HotelReviewInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.hotel.reviews.proto.HotelReviewInfo parseFrom(
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
  public static Builder newBuilder(com.hotel.reviews.proto.HotelReviewInfo prototype) {
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
   * Protobuf type {@code com.hotel.reviews.proto.HotelReviewInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:com.hotel.reviews.proto.HotelReviewInfo)
      com.hotel.reviews.proto.HotelReviewInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.hotel.reviews.proto.Hotel.internal_static_com_hotel_reviews_proto_HotelReviewInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.hotel.reviews.proto.Hotel.internal_static_com_hotel_reviews_proto_HotelReviewInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.hotel.reviews.proto.HotelReviewInfo.class, com.hotel.reviews.proto.HotelReviewInfo.Builder.class);
    }

    // Construct using com.hotel.reviews.proto.HotelReviewInfo.newBuilder()
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
        getReviewsFieldBuilder();
      }
    }
    public Builder clear() {
      super.clear();
      hotelId_ = 0L;

      hotelReviewRating_ = 0D;

      if (reviewsBuilder_ == null) {
        reviews_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
      } else {
        reviewsBuilder_.clear();
      }
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.hotel.reviews.proto.Hotel.internal_static_com_hotel_reviews_proto_HotelReviewInfo_descriptor;
    }

    public com.hotel.reviews.proto.HotelReviewInfo getDefaultInstanceForType() {
      return com.hotel.reviews.proto.HotelReviewInfo.getDefaultInstance();
    }

    public com.hotel.reviews.proto.HotelReviewInfo build() {
      com.hotel.reviews.proto.HotelReviewInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.hotel.reviews.proto.HotelReviewInfo buildPartial() {
      com.hotel.reviews.proto.HotelReviewInfo result = new com.hotel.reviews.proto.HotelReviewInfo(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.hotelId_ = hotelId_;
      result.hotelReviewRating_ = hotelReviewRating_;
      if (reviewsBuilder_ == null) {
        if (((bitField0_ & 0x00000004) == 0x00000004)) {
          reviews_ = java.util.Collections.unmodifiableList(reviews_);
          bitField0_ = (bitField0_ & ~0x00000004);
        }
        result.reviews_ = reviews_;
      } else {
        result.reviews_ = reviewsBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof com.hotel.reviews.proto.HotelReviewInfo) {
        return mergeFrom((com.hotel.reviews.proto.HotelReviewInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.hotel.reviews.proto.HotelReviewInfo other) {
      if (other == com.hotel.reviews.proto.HotelReviewInfo.getDefaultInstance()) return this;
      if (other.getHotelId() != 0L) {
        setHotelId(other.getHotelId());
      }
      if (other.getHotelReviewRating() != 0D) {
        setHotelReviewRating(other.getHotelReviewRating());
      }
      if (reviewsBuilder_ == null) {
        if (!other.reviews_.isEmpty()) {
          if (reviews_.isEmpty()) {
            reviews_ = other.reviews_;
            bitField0_ = (bitField0_ & ~0x00000004);
          } else {
            ensureReviewsIsMutable();
            reviews_.addAll(other.reviews_);
          }
          onChanged();
        }
      } else {
        if (!other.reviews_.isEmpty()) {
          if (reviewsBuilder_.isEmpty()) {
            reviewsBuilder_.dispose();
            reviewsBuilder_ = null;
            reviews_ = other.reviews_;
            bitField0_ = (bitField0_ & ~0x00000004);
            reviewsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getReviewsFieldBuilder() : null;
          } else {
            reviewsBuilder_.addAllMessages(other.reviews_);
          }
        }
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
      com.hotel.reviews.proto.HotelReviewInfo parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.hotel.reviews.proto.HotelReviewInfo) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

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

    private double hotelReviewRating_ ;
    /**
     * <code>double hotelReviewRating = 2;</code>
     */
    public double getHotelReviewRating() {
      return hotelReviewRating_;
    }
    /**
     * <code>double hotelReviewRating = 2;</code>
     */
    public Builder setHotelReviewRating(double value) {
      
      hotelReviewRating_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>double hotelReviewRating = 2;</code>
     */
    public Builder clearHotelReviewRating() {
      
      hotelReviewRating_ = 0D;
      onChanged();
      return this;
    }

    private java.util.List<com.hotel.reviews.proto.Review> reviews_ =
      java.util.Collections.emptyList();
    private void ensureReviewsIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        reviews_ = new java.util.ArrayList<com.hotel.reviews.proto.Review>(reviews_);
        bitField0_ |= 0x00000004;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.hotel.reviews.proto.Review, com.hotel.reviews.proto.Review.Builder, com.hotel.reviews.proto.ReviewOrBuilder> reviewsBuilder_;

    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public java.util.List<com.hotel.reviews.proto.Review> getReviewsList() {
      if (reviewsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(reviews_);
      } else {
        return reviewsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public int getReviewsCount() {
      if (reviewsBuilder_ == null) {
        return reviews_.size();
      } else {
        return reviewsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public com.hotel.reviews.proto.Review getReviews(int index) {
      if (reviewsBuilder_ == null) {
        return reviews_.get(index);
      } else {
        return reviewsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder setReviews(
        int index, com.hotel.reviews.proto.Review value) {
      if (reviewsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReviewsIsMutable();
        reviews_.set(index, value);
        onChanged();
      } else {
        reviewsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder setReviews(
        int index, com.hotel.reviews.proto.Review.Builder builderForValue) {
      if (reviewsBuilder_ == null) {
        ensureReviewsIsMutable();
        reviews_.set(index, builderForValue.build());
        onChanged();
      } else {
        reviewsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder addReviews(com.hotel.reviews.proto.Review value) {
      if (reviewsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReviewsIsMutable();
        reviews_.add(value);
        onChanged();
      } else {
        reviewsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder addReviews(
        int index, com.hotel.reviews.proto.Review value) {
      if (reviewsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureReviewsIsMutable();
        reviews_.add(index, value);
        onChanged();
      } else {
        reviewsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder addReviews(
        com.hotel.reviews.proto.Review.Builder builderForValue) {
      if (reviewsBuilder_ == null) {
        ensureReviewsIsMutable();
        reviews_.add(builderForValue.build());
        onChanged();
      } else {
        reviewsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder addReviews(
        int index, com.hotel.reviews.proto.Review.Builder builderForValue) {
      if (reviewsBuilder_ == null) {
        ensureReviewsIsMutable();
        reviews_.add(index, builderForValue.build());
        onChanged();
      } else {
        reviewsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder addAllReviews(
        java.lang.Iterable<? extends com.hotel.reviews.proto.Review> values) {
      if (reviewsBuilder_ == null) {
        ensureReviewsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, reviews_);
        onChanged();
      } else {
        reviewsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder clearReviews() {
      if (reviewsBuilder_ == null) {
        reviews_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000004);
        onChanged();
      } else {
        reviewsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public Builder removeReviews(int index) {
      if (reviewsBuilder_ == null) {
        ensureReviewsIsMutable();
        reviews_.remove(index);
        onChanged();
      } else {
        reviewsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public com.hotel.reviews.proto.Review.Builder getReviewsBuilder(
        int index) {
      return getReviewsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public com.hotel.reviews.proto.ReviewOrBuilder getReviewsOrBuilder(
        int index) {
      if (reviewsBuilder_ == null) {
        return reviews_.get(index);  } else {
        return reviewsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public java.util.List<? extends com.hotel.reviews.proto.ReviewOrBuilder> 
         getReviewsOrBuilderList() {
      if (reviewsBuilder_ != null) {
        return reviewsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(reviews_);
      }
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public com.hotel.reviews.proto.Review.Builder addReviewsBuilder() {
      return getReviewsFieldBuilder().addBuilder(
          com.hotel.reviews.proto.Review.getDefaultInstance());
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public com.hotel.reviews.proto.Review.Builder addReviewsBuilder(
        int index) {
      return getReviewsFieldBuilder().addBuilder(
          index, com.hotel.reviews.proto.Review.getDefaultInstance());
    }
    /**
     * <code>repeated .com.hotel.reviews.proto.Review reviews = 3;</code>
     */
    public java.util.List<com.hotel.reviews.proto.Review.Builder> 
         getReviewsBuilderList() {
      return getReviewsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.hotel.reviews.proto.Review, com.hotel.reviews.proto.Review.Builder, com.hotel.reviews.proto.ReviewOrBuilder> 
        getReviewsFieldBuilder() {
      if (reviewsBuilder_ == null) {
        reviewsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.hotel.reviews.proto.Review, com.hotel.reviews.proto.Review.Builder, com.hotel.reviews.proto.ReviewOrBuilder>(
                reviews_,
                ((bitField0_ & 0x00000004) == 0x00000004),
                getParentForChildren(),
                isClean());
        reviews_ = null;
      }
      return reviewsBuilder_;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:com.hotel.reviews.proto.HotelReviewInfo)
  }

  // @@protoc_insertion_point(class_scope:com.hotel.reviews.proto.HotelReviewInfo)
  private static final com.hotel.reviews.proto.HotelReviewInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.hotel.reviews.proto.HotelReviewInfo();
  }

  public static com.hotel.reviews.proto.HotelReviewInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<HotelReviewInfo>
      PARSER = new com.google.protobuf.AbstractParser<HotelReviewInfo>() {
    public HotelReviewInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new HotelReviewInfo(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<HotelReviewInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<HotelReviewInfo> getParserForType() {
    return PARSER;
  }

  public com.hotel.reviews.proto.HotelReviewInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

