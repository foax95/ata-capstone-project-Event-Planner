package com.kenzie.capstone.service.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kenzie.capstone.service.exceptions.InvalidDataException;
<<<<<<< HEAD
import com.sun.jdi.request.EventRequest;

public class JsonStringToEventConverter {
    public EventRequest convert(String body) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            EventRequest referralRequest = gson.fromJson(body, EventRequest.class);
            return referralRequest;
=======
import com.kenzie.capstone.service.model.LambdaEventRequest;

public class JsonStringToEventConverter {
    public LambdaEventRequest convert(String body) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(body, LambdaEventRequest.class);
>>>>>>> origin/main
        } catch (Exception e) {
            throw new InvalidDataException("Referral could not be deserialized");
        }
    }
}
