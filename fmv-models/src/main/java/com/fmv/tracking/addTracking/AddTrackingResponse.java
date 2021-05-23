package com.fmv.tracking.addTracking;

import com.fmv.IResponse;
import com.fmv.TrackingState;
import lombok.Data;

@Data
public class AddTrackingResponse implements IResponse {

    private String customerId;
    private String message;
    private TrackingState trackingState;

}
