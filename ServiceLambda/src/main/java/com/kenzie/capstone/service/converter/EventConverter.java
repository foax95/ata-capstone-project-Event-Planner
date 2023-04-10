package com.kenzie.capstone.service.converter;

<<<<<<< HEAD
import com.kenzie.capstone.service.model.Event;
import com.kenzie.capstone.service.model.EventRecord;
import com.kenzie.capstone.service.model.EventRequest;
import com.kenzie.capstone.service.model.EventResponse;

=======
import com.kenzie.capstone.service.model.*;
>>>>>>> origin/main


public class EventConverter {

<<<<<<< HEAD
    public static EventRecord fromRequestToRecord(EventRequest event) {
        EventRecord record = new EventRecord();
=======
    public static LambdaEventRecord fromRequestToRecord(LambdaEventRequest event) {
        LambdaEventRecord record = new LambdaEventRecord();
>>>>>>> origin/main
        record.setEventId(event.getEventId());
        record.setCustomerName(event.getCustomerName());
        record.setCustomerEmail(event.getCustomerEmail());
        record.setDate(event.getDate());
        record.setStatus(event.getStatus());
        return record;
    }

<<<<<<< HEAD
    public static EventResponse fromRecordToResponse(EventRecord record) {
        EventResponse eventResponse = new EventResponse();
=======
    public static LambdaEventResponse fromRecordToResponse(LambdaEventRecord record) {
        LambdaEventResponse eventResponse = new LambdaEventResponse();
>>>>>>> origin/main
        eventResponse.setEventId(record.getEventId());
        eventResponse.setCustomerName(record.getCustomerName());
        eventResponse.setCustomerEmail(record.getCustomerEmail());
        eventResponse.setDate(record.getDate());
        eventResponse.setStatus(record.getStatus());
        return eventResponse;
    }

<<<<<<< HEAD
    public static Event fromRecordToReferral(EventRecord record) {
        Event event = new Event();
        event.setEventId(record.getEventId());
        event.setEventDate(record.getDate());
        event.setEventStatus(record.getStatus());
        event.setCustomerEmail(record.getCustomerEmail());
        event.setCustomerName(record.getCustomerName());
        return event;
    }
=======
>>>>>>> origin/main
}
