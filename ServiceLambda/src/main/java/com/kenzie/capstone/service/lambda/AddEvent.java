package com.kenzie.capstone.service.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kenzie.capstone.service.LambdaService;
import com.kenzie.capstone.service.converter.JsonStringToEventConverter;
import com.kenzie.capstone.service.dependency.DaggerServiceComponent;
import com.kenzie.capstone.service.dependency.ServiceComponent;
import com.kenzie.capstone.service.exceptions.InvalidDataException;
import com.kenzie.capstone.service.model.EventResponse;
import com.kenzie.capstone.service.model.EventRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddEvent  implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    static final Logger log = LogManager.getLogger();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        JsonStringToEventConverter jsonStringToEventConverter = new JsonStringToEventConverter();
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        // Logging the request json to make debugging easier.
        log.info(gson.toJson(input));

        ServiceComponent serviceComponent = DaggerServiceComponent.create();
        LambdaService lambdaService = serviceComponent.provideLambdaService();

        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

        try {
            EventRequest eventRequest = jsonStringToEventConverter.convert(input.getBody());

            EventResponse eventResponse = lambdaService.addEvent(eventRequest);
            return response
                    .withStatusCode(200)
                    .withBody(gson.toJson(eventResponse));
        } catch (InvalidDataException e) {
            return response
                    .withStatusCode(400)
                    .withBody(gson.toJson(e.errorPayload()));
        }
    }

}
