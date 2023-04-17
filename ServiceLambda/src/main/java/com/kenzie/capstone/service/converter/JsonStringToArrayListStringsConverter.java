package com.kenzie.capstone.service.converter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.kenzie.capstone.service.exceptions.InvalidDataException;

import java.util.ArrayList;

public class JsonStringToArrayListStringsConverter {
    public ArrayList<String> convert(String body) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            return gson.fromJson(body, new TypeToken<ArrayList<String>>() {}.getType());
        } catch (Exception e) {
            throw new InvalidDataException("Body \"" + body + "\" could not be deserialized into an ArrayList<String>");
        }
    }
}
