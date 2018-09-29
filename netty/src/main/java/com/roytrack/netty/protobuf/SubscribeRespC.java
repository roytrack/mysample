// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: SubscribeResp.proto

package com.roytrack.netty.protobuf;

public final class SubscribeRespC {
  private static final com.google.protobuf.Descriptors.Descriptor
          internal_static_netty_SubscribeResp_descriptor;
  private static final
  com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internal_static_netty_SubscribeResp_fieldAccessorTable;
  private static com.google.protobuf.Descriptors.FileDescriptor
          descriptor;

  static {
    java.lang.String[] descriptorData = {
            "\n\023SubscribeResp.proto\022\005netty\"A\n\rSubscrib" +
                    "eResp\022\020\n\010subReqid\030\001 \001(\005\022\020\n\010respCode\030\002 \001(" +
                    "\005\022\014\n\004desc\030\003 \001(\tB-\n\033com.roytrack.netty.pr" +
                    "otobufB\016SubscribeRespCb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
            new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
              public com.google.protobuf.ExtensionRegistry assignDescriptors(
                      com.google.protobuf.Descriptors.FileDescriptor root) {
                descriptor = root;
                return null;
              }
            };
    com.google.protobuf.Descriptors.FileDescriptor
            .internalBuildGeneratedFileFrom(descriptorData,
                    new com.google.protobuf.Descriptors.FileDescriptor[]{
                    }, assigner);
    internal_static_netty_SubscribeResp_descriptor =
            getDescriptor().getMessageTypes().get(0);
    internal_static_netty_SubscribeResp_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
            internal_static_netty_SubscribeResp_descriptor,
            new java.lang.String[]{"SubReqid", "RespCode", "Desc",});
  }

  private SubscribeRespC() {
  }

  public static void registerAllExtensions(
          com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
          com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
            (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
  getDescriptor() {
    return descriptor;
  }

  public interface SubscribeRespOrBuilder extends
          // @@protoc_insertion_point(interface_extends:netty.SubscribeResp)
          com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional int32 subReqid = 1;</code>
     */
    int getSubReqid();

    /**
     * <code>optional int32 respCode = 2;</code>
     */
    int getRespCode();

    /**
     * <code>optional string desc = 3;</code>
     */
    java.lang.String getDesc();

    /**
     * <code>optional string desc = 3;</code>
     */
    com.google.protobuf.ByteString
    getDescBytes();
  }

  /**
   * Protobuf type {@code netty.SubscribeResp}
   */
  public static final class SubscribeResp extends
          com.google.protobuf.GeneratedMessageV3 implements
          // @@protoc_insertion_point(message_implements:netty.SubscribeResp)
          SubscribeRespOrBuilder {
    public static final int SUBREQID_FIELD_NUMBER = 1;
    public static final int RESPCODE_FIELD_NUMBER = 2;
    public static final int DESC_FIELD_NUMBER = 3;
    private static final long serialVersionUID = 0L;
    // @@protoc_insertion_point(class_scope:netty.SubscribeResp)
    private static final com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp DEFAULT_INSTANCE;
    private static final com.google.protobuf.Parser<SubscribeResp>
            PARSER = new com.google.protobuf.AbstractParser<SubscribeResp>() {
      public SubscribeResp parsePartialFrom(
              com.google.protobuf.CodedInputStream input,
              com.google.protobuf.ExtensionRegistryLite extensionRegistry)
              throws com.google.protobuf.InvalidProtocolBufferException {
        return new SubscribeResp(input, extensionRegistry);
      }
    };

    static {
      DEFAULT_INSTANCE = new com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp();
    }

    private int subReqid_;
    private int respCode_;
    private volatile java.lang.Object desc_;
    private byte memoizedIsInitialized = -1;

    // Use SubscribeResp.newBuilder() to construct.
    private SubscribeResp(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }

    private SubscribeResp() {
      subReqid_ = 0;
      respCode_ = 0;
      desc_ = "";
    }
    private SubscribeResp(
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

              subReqid_ = input.readInt32();
              break;
            }
            case 16: {

              respCode_ = input.readInt32();
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              desc_ = s;
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
      return com.roytrack.netty.protobuf.SubscribeRespC.internal_static_netty_SubscribeResp_descriptor;
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseFrom(
            com.google.protobuf.ByteString data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseFrom(
            com.google.protobuf.ByteString data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseFrom(byte[] data)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseFrom(
            byte[] data,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseDelimitedFrom(java.io.InputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseDelimitedFrom(
            java.io.InputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseFrom(
            com.google.protobuf.CodedInputStream input)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parseFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
              .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }

    public static Builder newBuilder(com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }

    public static com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    public static com.google.protobuf.Parser<SubscribeResp> parser() {
      return PARSER;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
    internalGetFieldAccessorTable() {
      return com.roytrack.netty.protobuf.SubscribeRespC.internal_static_netty_SubscribeResp_fieldAccessorTable
              .ensureFieldAccessorsInitialized(
                      com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp.class, com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp.Builder.class);
    }

    /**
     * <code>optional int32 subReqid = 1;</code>
     */
    public int getSubReqid() {
      return subReqid_;
    }

    /**
     * <code>optional int32 respCode = 2;</code>
     */
    public int getRespCode() {
      return respCode_;
    }

    /**
     * <code>optional string desc = 3;</code>
     */
    public java.lang.String getDesc() {
      java.lang.Object ref = desc_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs =
                (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        desc_ = s;
        return s;
      }
    }

    /**
     * <code>optional string desc = 3;</code>
     */
    public com.google.protobuf.ByteString
    getDescBytes() {
      java.lang.Object ref = desc_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b =
                com.google.protobuf.ByteString.copyFromUtf8(
                        (java.lang.String) ref);
        desc_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
            throws java.io.IOException {
      if (subReqid_ != 0) {
        output.writeInt32(1, subReqid_);
      }
      if (respCode_ != 0) {
        output.writeInt32(2, respCode_);
      }
      if (!getDescBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, desc_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (subReqid_ != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeInt32Size(1, subReqid_);
      }
      if (respCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
                .computeInt32Size(2, respCode_);
      }
      if (!getDescBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, desc_);
      }
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
        return true;
      }
      if (!(obj instanceof com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp)) {
        return super.equals(obj);
      }
      com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp other = (com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp) obj;

      boolean result = true;
      result = result && (getSubReqid()
              == other.getSubReqid());
      result = result && (getRespCode()
              == other.getRespCode());
      result = result && getDesc()
              .equals(other.getDesc());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + SUBREQID_FIELD_NUMBER;
      hash = (53 * hash) + getSubReqid();
      hash = (37 * hash) + RESPCODE_FIELD_NUMBER;
      hash = (53 * hash) + getRespCode();
      hash = (37 * hash) + DESC_FIELD_NUMBER;
      hash = (53 * hash) + getDesc().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public Builder newBuilderForType() {
      return newBuilder();
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

    @java.lang.Override
    public com.google.protobuf.Parser<SubscribeResp> getParserForType() {
      return PARSER;
    }

    public com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

    /**
     * Protobuf type {@code netty.SubscribeResp}
     */
    public static final class Builder extends
            com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
            // @@protoc_insertion_point(builder_implements:netty.SubscribeResp)
            com.roytrack.netty.protobuf.SubscribeRespC.SubscribeRespOrBuilder {
      private int subReqid_;
      private int respCode_;
      private java.lang.Object desc_ = "";

      // Construct using com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
              com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }

      public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
        return com.roytrack.netty.protobuf.SubscribeRespC.internal_static_netty_SubscribeResp_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
        return com.roytrack.netty.protobuf.SubscribeRespC.internal_static_netty_SubscribeResp_fieldAccessorTable
                .ensureFieldAccessorsInitialized(
                        com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp.class, com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp.Builder.class);
      }

      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }

      public Builder clear() {
        super.clear();
        subReqid_ = 0;

        respCode_ = 0;

        desc_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
      getDescriptorForType() {
        return com.roytrack.netty.protobuf.SubscribeRespC.internal_static_netty_SubscribeResp_descriptor;
      }

      public com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp getDefaultInstanceForType() {
        return com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp.getDefaultInstance();
      }

      public com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp build() {
        com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp buildPartial() {
        com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp result = new com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp(this);
        result.subReqid_ = subReqid_;
        result.respCode_ = respCode_;
        result.desc_ = desc_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return super.clone();
      }

      public Builder setField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              Object value) {
        return super.setField(field, value);
      }

      public Builder clearField(
              com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }

      public Builder clearOneof(
              com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }

      public Builder setRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              int index, Object value) {
        return super.setRepeatedField(field, index, value);
      }

      public Builder addRepeatedField(
              com.google.protobuf.Descriptors.FieldDescriptor field,
              Object value) {
        return super.addRepeatedField(field, value);
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp) {
          return mergeFrom((com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp) other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp other) {
        if (other == com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp.getDefaultInstance()) return this;
        if (other.getSubReqid() != 0) {
          setSubReqid(other.getSubReqid());
        }
        if (other.getRespCode() != 0) {
          setRespCode(other.getRespCode());
        }
        if (!other.getDesc().isEmpty()) {
          desc_ = other.desc_;
          onChanged();
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
        com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.roytrack.netty.protobuf.SubscribeRespC.SubscribeResp) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      /**
       * <code>optional int32 subReqid = 1;</code>
       */
      public int getSubReqid() {
        return subReqid_;
      }

      /**
       * <code>optional int32 subReqid = 1;</code>
       */
      public Builder setSubReqid(int value) {

        subReqid_ = value;
        onChanged();
        return this;
      }

      /**
       * <code>optional int32 subReqid = 1;</code>
       */
      public Builder clearSubReqid() {

        subReqid_ = 0;
        onChanged();
        return this;
      }

      /**
       * <code>optional int32 respCode = 2;</code>
       */
      public int getRespCode() {
        return respCode_;
      }

      /**
       * <code>optional int32 respCode = 2;</code>
       */
      public Builder setRespCode(int value) {

        respCode_ = value;
        onChanged();
        return this;
      }

      /**
       * <code>optional int32 respCode = 2;</code>
       */
      public Builder clearRespCode() {

        respCode_ = 0;
        onChanged();
        return this;
      }

      /**
       * <code>optional string desc = 3;</code>
       */
      public java.lang.String getDesc() {
        java.lang.Object ref = desc_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
                  (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          desc_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }

      /**
       * <code>optional string desc = 3;</code>
       */
      public Builder setDesc(
              java.lang.String value) {
        if (value == null) {
          throw new NullPointerException();
        }

        desc_ = value;
        onChanged();
        return this;
      }

      /**
       * <code>optional string desc = 3;</code>
       */
      public com.google.protobuf.ByteString
      getDescBytes() {
        java.lang.Object ref = desc_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b =
                  com.google.protobuf.ByteString.copyFromUtf8(
                          (java.lang.String) ref);
          desc_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }

      /**
       * <code>optional string desc = 3;</code>
       */
      public Builder setDescBytes(
              com.google.protobuf.ByteString value) {
        if (value == null) {
          throw new NullPointerException();
        }
        checkByteStringIsUtf8(value);

        desc_ = value;
        onChanged();
        return this;
      }

      /**
       * <code>optional string desc = 3;</code>
       */
      public Builder clearDesc() {

        desc_ = getDefaultInstance().getDesc();
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


      // @@protoc_insertion_point(builder_scope:netty.SubscribeResp)
    }

  }

  // @@protoc_insertion_point(outer_class_scope)
}
