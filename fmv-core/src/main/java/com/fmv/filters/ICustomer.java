package com.fmv.filters;

import com.fmv.TrackingState;

public interface ICustomer extends IEntity {

    String getExternalId();

    String getPhoneNumber();

    TrackingState getTrackingState();

    void setExternalId(String externalId);

    void setPhoneNumber(String phoneNumber);

    void setTrackingState(TrackingState trackingState);

}
