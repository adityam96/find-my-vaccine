package com.fmv.services;

import com.fmv.customer.CustomerRequest;
import com.fmv.customer.CustomerResponse;

public interface ICustomerService extends IFmvService {

    /**
     1. Primary check: Validate if correct phone number
     2. Secondary Check: Check if already exists, and Validate if it is a whatsapp number
     3. Register customer and store details in db
     **/
    CustomerResponse registerByPhoneNumber(CustomerRequest customerRequest);

    /**
     1. Primary check: Validate if correct phone number
     2. Get Customer details using phone number
     *
     * @param
     * @return*/
    CustomerResponse getByPhoneNumber(String phoneNumber);
}
