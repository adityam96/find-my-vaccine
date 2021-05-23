package com.fmv.notification;

import com.fmv.IResponse;
import lombok.Data;

@Data
public class NotifyCustomerResponse implements IResponse {
    private Boolean status;
    private String msg;
}
