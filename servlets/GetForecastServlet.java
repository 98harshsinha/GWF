package com.adobe.core.servlets;

import com.adobe.core.services.GetForecastService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

@Component(service = Servlet.class)
@SlingServletResourceTypes(
        resourceTypes = "training/components/page"
)
public class GetForecastServlet extends SlingSafeMethodsServlet {
    @Reference
    GetForecastService getForecastService;

    @Override
    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException , ServletException {
        String ans="";
        try {
            ans=getForecastService.getResponse(request.getParameter("ip"));
        }
        catch (Exception e) {
           response.getWriter().write(e+"");
        }
        response.setContentType("text/json");
        response.getWriter().write(ans);
    }


}
