package com.fmv.notification;

import com.fmv.IRequest;
import com.fmv.NotificationType;
import lombok.Data;

import java.util.Map;

@Data
public class NotifyCustomerRequest implements IRequest {
    private String customerId;
    private NotificationType notificationType;
    private Map<String, String> context;
}
