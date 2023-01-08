package com.adobe.core.services;

import org.json.JSONException;

import java.io.IOException;
import java.net.URISyntaxException;

public interface GetForecastService {
    public String getResponse(String ip) throws IOException, InterruptedException, URISyntaxException, JSONException;
}
