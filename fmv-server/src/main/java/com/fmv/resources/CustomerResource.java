package com.fmv.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.fmv.customer.CustomerRequest;
import com.fmv.services.ICoreService;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Singleton
@Path("/register/")
public class CustomerResource {

    private final ICoreService coreService;

    @Inject
    public CustomerResource(ICoreService coreService) {
        this.coreService = coreService;
    }

    @GET
    @Path("/customer/{phoneNumber}")
    @ExceptionMetered
    @Timed
    @UnitOfWork
    public Response getByPhoneNumber(@PathParam("phoneNumber") String phoneNumber) {
        return Response.ok(coreService.getByPhoneNumber(phoneNumber)).build();
    }

    @POST
    @Path("/customer")
    @ExceptionMetered
    @Timed
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(CustomerRequest customerRequest) {
        return Response.ok(coreService.registerCustomer(customerRequest)).build();
    }
}
