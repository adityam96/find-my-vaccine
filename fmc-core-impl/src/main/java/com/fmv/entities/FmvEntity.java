package com.fmv.entities;

import lombok.Data;

import java.sql.Date;

@Data
public class FmvEntity implements IEntity {
    String externalId;
    Date createdAt;
    Date updatedAt;
    String createdByUser;
    String lastUpdatedByUser;
}
