package com.fmv.bootstrap;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class FmvConfiguration extends Configuration {
    
    @JsonProperty("database")
    @NotNull
    private DataSourceFactory dataSourceFactory;

}
