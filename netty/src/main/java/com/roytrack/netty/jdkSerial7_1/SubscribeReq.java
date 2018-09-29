package com.roytrack.netty.jdkSerial7_1;

import java.io.Serializable;

/**
 * Created by roytrack on 2016-10-17.
 */
public class SubscribeReq implements Serializable {
  private static final long serialVersionUID = 1L;
  private int subSeqID;
  private String userName;
  private String productName;
  private String phoneNumber;
  private String address;

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public int getSubSeqID() {
    return subSeqID;
  }

  public void setSubSeqID(int subSeqID) {
    this.subSeqID = subSeqID;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "SubscribeReq[subReqId=" + subSeqID + ", userName=" + userName + ", productName=" + productName
            + ", phoneNumber=" + phoneNumber + ", address=" + address;
  }
}
