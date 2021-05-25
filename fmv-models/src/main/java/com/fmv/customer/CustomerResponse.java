package com.fmv.customer;

import com.fmv.IResponse;
import lombok.Data;

@Data
public class CustomerResponse implements IResponse {

    private String customerId;
    private String name;
    private String phoneNumber;
    private String trackingState;

}
