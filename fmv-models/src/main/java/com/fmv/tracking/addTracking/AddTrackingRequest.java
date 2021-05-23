package com.fmv.tracking.addTracking;

import com.fmv.IRequest;
import com.fmv.TrackingType;
import lombok.Data;

import java.util.Map;

@Data
public class AddTrackingRequest implements IRequest {

    private String customerId;
    private TrackingType trackingType;
    private Map<DataType, String> context;

    public enum DataType {
        PIN_CODE,
        DISTRICT,
        STATE
    }
}
