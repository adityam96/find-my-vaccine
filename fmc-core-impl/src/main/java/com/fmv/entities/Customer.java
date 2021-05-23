package com.fmv.entities;

import com.fmv.TrackingState;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Customer extends FmvEntity implements ICustomer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String phoneNumber;

    TrackingState trackingState;

}
