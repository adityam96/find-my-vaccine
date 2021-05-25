package com.fmv.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Data
public class Customer extends FmvEntity implements ICustomer {

    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String phoneNumber;

    String trackingState;

    @Override
    public String getPrefix() {
        return "CU";
    }
}
