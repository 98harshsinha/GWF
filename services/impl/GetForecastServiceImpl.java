package com.adobe.core.services.impl;


import com.adobe.core.services.GetForecastService;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;
import static com.adobe.core.utils.CallingApi.hitApi;

@Component(service = GetForecastService.class,immediate = true)
@Designate(ocd= GetForecastServiceConfiguration.class)
public class GetForecastServiceImpl implements GetForecastService {



    private static final Logger LOGGER = LoggerFactory.getLogger(GetForecastServiceImpl.class);
        private String apiSite;
        private String accessKey;
        private String weatherApi;
        private String secondAccessKey;
        private String finalResult;


    @Activate
    @Modified
    protected void activate(GetForecastServiceConfiguration config) {
            this.apiSite =config.apiSite();
            this.accessKey =config.accessKey();
            this.weatherApi =config.weatherApi();
            this.secondAccessKey =config.secondAccessKey();

        LOGGER.info("\n------------Activated--------------------");
    }

    @Deactivate
    public void deactivate(){
        LOGGER.info("\n ----------------Deactivated----------------");
    }



    @Override
    public String getResponse(String ip) throws IOException, URISyntaxException, JSONException {

        String result="";
        HttpRequest request= HttpRequest.newBuilder().GET().uri(URI.create(apiSite +ip+"?access_key="+ accessKey)).build();
        String ipAPIUrl= apiSite +ip+"?access_key="+ accessKey;
        result=hitApi(ipAPIUrl);
        JSONObject obj = new JSONObject(result);
        String success="";
        if(obj.has("success"))
         success =(String) obj.get("success");

    /*    // old part start
   String success= result.split(",")[0].split(":")[1];
     if(!success.contains("false")) {
         String city = "";
         for (String str : result.split(",")) {
             if (str.contains("city")) {
                 city = str.split(":")[1].replace("\"", "").trim();
                 break;
             }
         }
        // old part */
        String city="";
        if(!success.contains("false") || !success.equals("")){
             city=(String)obj.get("city");
        }
         if (city!=null && !"".equals(city)) {
             String urlParams = city + "&APPID=" + secondAccessKey;
             String url = weatherApi + urlParams;
             result = hitApi(url);

         }

     finalResult=result;
    return result;
    }
}


