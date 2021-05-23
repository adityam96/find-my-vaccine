package com.fmv.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.fmv.services.ICoreService;
import com.fmv.tracking.addTracking.AddTrackingRequest;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Singleton
@Path("/track/")
public class TrackingResource {

    private final ICoreService coreService;

    @Inject
    public TrackingResource(ICoreService coreService) {
        this.coreService = coreService;
    }

    @GET
    @Path("/{customerId}")
    @ExceptionMetered
    @Timed
    public Response getTrackingState(@QueryParam("customerId") String customerId) {
        return Response.ok(coreService.getTrackingState(customerId)).build();
    }

    @POST
    @Path("/")
    @ExceptionMetered
    @Timed
    public Response addTracking(AddTrackingRequest addTrackingRequest) {
        return Response.ok(coreService.addTracking(addTrackingRequest)).build();
    }

    @PUT
    @Path("/{customerId}")
    @ExceptionMetered
    @Timed
    public Response updateTracking(@QueryParam("customerId") String customerId,
                                   @QueryParam("pinCode") String pinCode) {
        return Response.ok(coreService.updateTracking(customerId, pinCode)).build();
    }

    @DELETE
    @Path("/{customerId}/")
    @ExceptionMetered
    @Timed
    public Response removeTracking(@QueryParam("customerId") String customerId) {
        return Response.ok(coreService.removeTracking(customerId)).build();
    }
}
