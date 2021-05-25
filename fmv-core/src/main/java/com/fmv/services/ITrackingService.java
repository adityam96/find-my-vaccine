package com.fmv.services;

import com.fmv.tracking.addTracking.AddTrackingRequest;
import com.fmv.tracking.addTracking.AddTrackingResponse;

public interface ITrackingService extends IFmvService {


    Object getTrackingState(String customerId);

    Object removeTrackingPinCode(String customerId);

    Object updateTrackingPinCode(String customerId, String pinCode);

    /**
     1. Primary check: Check of customer id is valid
     2. Add tracking details in db with corresponding details
     **/
    AddTrackingResponse addTracking(AddTrackingRequest addTrackingRequest);
}
