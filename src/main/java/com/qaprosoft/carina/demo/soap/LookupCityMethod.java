package com.qaprosoft.carina.demo.soap;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.ContentType;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;

@Endpoint(url = "${base_url}", methodType = HttpMethodType.POST)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@RequestTemplatePath(path = "api/soap/lookupcity/rq.xml")
@ResponseTemplatePath(path = "src/test/resources/api/soap/lookupcity/rs.xml")
@ContentType(type = "text/xml")
public class LookupCityMethod extends AbstractApiMethodV2 {

    public LookupCityMethod() {
        replaceUrlPlaceholder("base_url",Configuration.getEnvArg("soap_url"));
        setHeaders(String.format("SOAPAction=%s", "http://tempuri.org/SOAP.Demo.LookupCity"));
    }

}
