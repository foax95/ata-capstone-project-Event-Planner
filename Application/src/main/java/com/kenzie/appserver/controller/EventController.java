package com.kenzie.appserver.controller;

import com.kenzie.appserver.controller.model.CreateEventRequest;
import com.kenzie.appserver.controller.model.EventResponse;
import com.kenzie.appserver.repositories.model.EventRecord;
import com.kenzie.appserver.service.EventService;

import com.kenzie.appserver.service.model.Event;
import com.kenzie.capstone.service.client.LambdaServiceClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("/events")
public class EventController {

    private EventService eventService;

    EventController(EventService service) {
        //Rename it to avoid confusion and any possible bugs
        this.eventService = service;
    }

    @PostMapping
    public ResponseEntity<EventResponse> addNewEvent(@RequestBody CreateEventRequest createEvent) {
        //EventId is not needed here because it is auto generated in the Event class
        //String id = UUID.randomUUID().toString();

        /*if (createEvent.getCustomerName().get() == null || createEvent.getCustomerName().get().length() == 0 || createEvent.getCustomerEmail().get() == null || createEvent.getCustomerEmail().get().length() == 0 || createEvent.getDate().get() == null || createEvent.getDate().get().length() == 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Input");
        }
        Event event = new Event(createEvent.getCustomerName().get(), createEvent.getCustomerEmail().get(), createEvent.getDate().get(), createEvent.getStatus().get());

        if(event.getEventId() != null){
            EventResponse response = eventService.addNewEvent(event);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);

        }else{
            return ResponseEntity.status(HttpStatus.CREATED);
        }*/
        if(createEvent.getCustomerName().isPresent() && createEvent.getCustomerEmail().isPresent() && createEvent.getDate().isPresent()){
            EventResponse response = this.eventService.addNewEvent(createEvent);
            return ResponseEntity.created(URI.create("/events/" + response.getEventId())).body(response);
        }else{
            EventResponse emptyResponse = new EventResponse();
            return (ResponseEntity<EventResponse>) ResponseEntity.badRequest();
        }

        //return ResponseEntity.created(URI.create("/events/" + response.getEventId())).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EventResponse>> getAllEvents() {
        List<EventResponse> events = eventService.findAllEvents();
        if (events == null || events.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventResponse> searchEventById(@PathVariable("id") String eventId) {
        EventResponse response = eventService.findEventById(eventId);
        if (response == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEventById(@PathVariable("id") String eventId) {
        eventService.deleteEvent(eventId);
        return ResponseEntity.ok().build();
    }


}
