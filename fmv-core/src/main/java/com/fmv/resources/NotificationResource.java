package com.fmv.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.fmv.notification.NotifyCustomerRequest;
import com.fmv.services.ICoreService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Singleton
@Path("/notification/")
public class NotificationResource {

    private final ICoreService coreService;

    @Inject
    public NotificationResource(ICoreService coreService) {
        this.coreService = coreService;
    }

    @POST
    @Path("/notifyCustomer/")
    @ExceptionMetered
    @Timed
    public Response getByPhoneNumber(NotifyCustomerRequest request) {
        return Response.ok(coreService.notifyCustomer(request)).build();
    }

}
