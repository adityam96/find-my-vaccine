package com.fmv.customer;

import com.fmv.IRequest;
import lombok.Data;

@Data
public class CustomerRequest implements IRequest {

    private String name;
    private String phoneNumber;

}
