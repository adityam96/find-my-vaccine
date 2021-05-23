package com.fmv.entities;

import com.fmv.TrackingState;

public interface ICustomer extends IEntity {

    String getExternalId();

    String getName();

    String getPhoneNumber();

    TrackingState getTrackingState();

    void setExternalId(String externalId);

    void setPhoneNumber(String phoneNumber);

    void setTrackingState(TrackingState trackingState);

}
