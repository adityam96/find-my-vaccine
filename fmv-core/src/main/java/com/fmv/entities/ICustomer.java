package com.fmv.entities;

public interface ICustomer extends IEntity {

    String getExternalId();

    String getName();

    String getPhoneNumber();

    String getTrackingState();

    void setExternalId(String externalId);

    void setName(String name);

    void setPhoneNumber(String phoneNumber);

    void setTrackingState(String trackingState);

}
