package com.adobe.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Get Forecast Configuration",description = "GetForecast component service")
public @interface GetForecastServiceConfiguration {
         @AttributeDefinition(
             name = "IP API",
             description = "Put the IP API you want to use",
             type = AttributeType.STRING
             )
 String apiSite() default "http://api.ipapi.com/api/";
             @AttributeDefinition(
            name = "Access Key",
            description = "Put the Access Key you want to use",
            type = AttributeType.STRING
    )
    String accessKey() default "ca27720c46a18bcad63ab6af426eee4d";
    @AttributeDefinition(
            name = "Weather API",
            description = "Put the weather api you want to use",
            type = AttributeType.STRING
    )
    String weatherApi() default "http://api.openweathermap.org/data/2.5/weather?q=";
    @AttributeDefinition(
            name = "Second Access Key",
            description = "Put the second access key you want to use",
            type = AttributeType.STRING
    )
    String secondAccessKey() default "92eb752f76862b0aba5fe0703bd0929b";




}