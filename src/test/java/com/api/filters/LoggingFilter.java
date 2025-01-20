package com.api.filters;

import com.api.base.TestBase;
import com.api.listener.TestListener;
import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter extends TestBase implements Filter {

    private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification filterableRequestSpecification, FilterableResponseSpecification filterableResponseSpecification, FilterContext filterContext) {
        logRequest(filterableRequestSpecification);
        Response response = filterContext.next(filterableRequestSpecification, filterableResponseSpecification);
        logResponse(response);
        return response;
    }

    private void logRequest(FilterableRequestSpecification requestSpecification) {
        logger.info("BASE URI");
        logger.info(requestSpecification.getBaseUri());
        logger.info("-------------------------------");
        logger.info("HEADER");
        logger.info(requestSpecification.getHeaders());
        logger.info("-------------------------------");
        logger.info("BODY");
        logger.info("" + requestSpecification.getBody());
        extentTest.info("Request Details: ");
        extentTest.info("BASE URI: " + requestSpecification.getBaseUri());
        extentTest.info("HEADER: " + requestSpecification.getHeaders());
        extentTest.info("BODY: %n" + requestSpecification.getBody());
    }

    private void logResponse(Response response) {
        logger.info("-------------------------");
        logger.info("Response Log");
        logger.info("STATUS CODE: " + response.getStatusCode());
        logger.info("-------------------------");
        logger.info("RESPONSE HEADER" + response.getHeaders());
        logger.info("-------------------------");
        logger.info("Response");
        logger.info(response.asPrettyString());

        extentTest.info("Response Details: ");
        extentTest.info("STATUS CODE: " + response.getStatusCode());
        extentTest.info("HEADER" + response.getHeaders());
        extentTest.info(response.asPrettyString());
    }
}
