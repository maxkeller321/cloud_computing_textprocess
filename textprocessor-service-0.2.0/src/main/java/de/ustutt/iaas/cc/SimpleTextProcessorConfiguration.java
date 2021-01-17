package de.ustutt.iaas.cc;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

public class SimpleTextProcessorConfiguration extends Configuration {

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    private String serviceInstanceID;

    @JsonProperty("serviceInstanceID")
    public String getServiceInstanceID() {
	return serviceInstanceID;
    }

    public void setServiceInstanceID(String serviceInstanceID) {
	this.serviceInstanceID = serviceInstanceID;
    }

}
