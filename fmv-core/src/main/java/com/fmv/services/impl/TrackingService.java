package com.fmv.services.impl;

import com.fmv.services.ITrackingService;
import com.fmv.tracking.addTracking.AddTrackingRequest;
import com.fmv.tracking.addTracking.AddTrackingResponse;

public class TrackingService implements ITrackingService {

    @Override
    public Object getTrackingPinCode(String customerId) {
        return null;
    }

    @Override
    public Object removeTrackingPinCode(String customerId) {
        return null;
    }

    @Override
    public Object updateTrackingPinCode(String customerId, String pinCode) {
        return null;
    }

    @Override
    public AddTrackingResponse addTracking(AddTrackingRequest addTrackingRequest) {

        return null;
    }

    @Override
    public void start() throws Exception {
    }

    @Override
    public void stop() throws Exception {
    }
}
