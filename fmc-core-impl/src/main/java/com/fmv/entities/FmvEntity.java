package com.fmv.entities;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

@MappedSuperclass
@Data
public abstract class FmvEntity implements IEntity {

    @Id
    String externalId;
    Date createdAt;
    Date updatedAt;
    String createdByUser;
    String lastUpdatedByUser;
}
