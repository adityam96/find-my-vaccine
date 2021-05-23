package com.fmv.filters;


import java.sql.Date;

public interface IEntity {

    Date getCreatedAt();

    Date getUpdatedAt();

    void setUpdatedAt(Date date);

    void setCreatedAt(Date date);

    String getCreatedByUser();

    String getLastUpdatedByUser();

    void setCreatedByUser(String user);

    void setLastUpdatedByUser(String user);

}
