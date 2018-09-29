package com.roytrack.kryo.factory;


import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;
import com.roytrack.kryo.common.Cleanable;
import com.roytrack.kryo.common.ObjectOutput;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author lishen
 */
public class KryoObjectOutput implements ObjectOutput, Cleanable {

  private Kryo kryo = KryoFactory.getDefaultFactory().getKryo();
  private Output output;

  public KryoObjectOutput(OutputStream outputStream) {
    output = new Output(outputStream);
  }

  public void writeBool(boolean v) {
    output.writeBoolean(v);
  }

  public void writeByte(byte v) {
    output.writeByte(v);
  }

  public void writeShort(short v) {
    output.writeShort(v);
  }

  public void writeInt(int v) {
    output.writeInt(v);
  }

  public void writeLong(long v) {
    output.writeLong(v);
  }

  public void writeFloat(float v) {
    output.writeFloat(v);
  }

  public void writeDouble(double v) {
    output.writeDouble(v);
  }

  public void writeBytes(byte[] v) throws IOException {
    if (v == null) {
      output.writeInt(-1);
    } else {
      writeBytes(v, 0, v.length);
    }
  }

  public void writeBytes(byte[] v, int off, int len) {
    if (v == null) {
      output.writeInt(-1);
    } else {
      output.writeInt(len);
      output.write(v, off, len);
    }
  }


  public void writeUTF(String v) {
    // TODO
    output.writeString(v);
//        kryo.writeObject(output, v);
  }

  public void writeObject(Object v) {
    kryo.writeClassAndObject(output, v);
  }

  public void flushBuffer() {
    output.flush();
  }

  public void cleanup() {
    KryoFactory.getDefaultFactory().returnKryo(kryo);
    kryo = null;
  }
}