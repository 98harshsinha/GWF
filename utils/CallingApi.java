package com.adobe.core.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class CallingApi {
    public static String hitApi(String url) throws URISyntaxException, IOException {
        String ans="";
        HttpClient httpClient1 = HttpClients.custom()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setCookieSpec(CookieSpecs.STANDARD).build())
                .build();
        URIBuilder uriBuilder = new URIBuilder(url);
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Content-Type", "json");
       HttpResponse response1 = httpClient1.execute(httpGet);
        HttpEntity entity = response1.getEntity();
        if (null != entity) {
            ans = EntityUtils.toString(entity, "UTF-8");
        }
        return ans;
    }
}
