package com.fmv.customer;

import com.fmv.IResponse;
import lombok.Data;

@Data
public class CustomerResponse implements IResponse {

    private String customerId;
    private String customerName;
    private String phoneNumber;
    private String message;
    private Boolean isRegistered;

}
