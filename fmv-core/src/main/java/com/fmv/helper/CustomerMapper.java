package com.fmv.helper;

import com.fmv.customer.CustomerRequest;
import com.fmv.customer.CustomerResponse;
import com.fmv.entities.ICustomer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    void setCustomerFromRequest(CustomerRequest customerRequest, @MappingTarget ICustomer customer);

    CustomerResponse getResponse(ICustomer customer);

}
