package com.kenzie.appserver.controller;

import com.kenzie.appserver.IntegrationTest;
import com.kenzie.appserver.controller.model.CreateEventRequest;
import com.kenzie.appserver.service.EventService;
import com.kenzie.appserver.service.model.Event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@IntegrationTest
class EventControllerTest {
    @Autowired
    private MockMvc mvc;

    @Autowired
    EventService eventService;

    private final ObjectMapper mapper = new ObjectMapper();

<<<<<<< HEAD
    @Test
    public void getByEventId_Exists() throws Exception {

        String event = mockNeat.strings().valStr();

        Event persistedEvent = eventService.addNewStringEvent(event);
        //addNewEvent in EventService returns EventRecord instead of String
        //original ExampleService file had String type https://tinyurl.com/addNewExample

        mvc.perform(get("/event/{eventId}", persistedEvent.getEventId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("eventId")
                        .isString())
                .andExpect(jsonPath("event")
                        .value(is(event)))
                .andExpect(status().is2xxSuccessful());
=======

    @Test
    public void getByEventId_Exists() throws Exception {

        String id = UUID.randomUUID().toString();
        Event event = new Event(id, "Thor", "godOfThunder@valhalla.com", LocalDate.now().toString(), "Event Created");
        eventService.addNewEvent(event);

        mvc.perform(get("/events/{eventId}", id)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.eventId", is(id)));

        eventService.deleteEvent(id);
    }

    @Test
    public void getAllEvents_Exists() throws Exception {
        String id = UUID.randomUUID().toString();
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        Event event = new Event(id, "Thor", "godOfThunder@valhalla.com", LocalDate.now().toString(), "Event Created");
        Event event1 = new Event(id1, "Loki", "loki@valhalla.com", LocalDate.now().toString(), "Event Created");
        Event event2 = new Event(id2, "Captain America", "americasbestbutt@Merica.com", LocalDate.now().toString(), "Event Created");
        eventService.addNewEvent(event);
        eventService.addNewEvent(event1);
        eventService.addNewEvent(event2);


        mvc.perform(get("/events/all")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200));

        eventService.deleteEvent(id);
        eventService.deleteEvent(id1);
        eventService.deleteEvent(id2);

>>>>>>> origin/main
    }

    @Test
    public void createEvent_CreateSuccessful() throws Exception {
        String date = LocalDate.now().toString();
        String customerName = "Erica";
        String customerEmail = "email";
        String eventId = UUID.randomUUID().toString();

        CreateEventRequest request = new CreateEventRequest();
        request.setCustomerName(customerName);
        request.setCustomerEmail(customerEmail);
        request.setEventId(eventId);
        request.setDate(date);
        request.setStatus("upcoming");

        mapper.registerModule(new JavaTimeModule());

        String json = mapper.writeValueAsString(request);

        mvc.perform(post("/events")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void getEvent_EventDoesNotExist() throws Exception {
        String eventId = UUID.randomUUID().toString();

        mvc.perform(get("/events/{eventId}", eventId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());

    }

    @Test
    public void updateEvent_UpdatesEvent() throws Exception{
        String eventId = UUID.randomUUID().toString();
        String date = LocalDate.now().toString();
        String status = "upcoming";
<<<<<<< HEAD
        String customerName = "Erica";
        String customerEmail = "erica.muse@mykenzie.snhu.edu";

        Event event = new Event(eventId,date,status,customerName,customerEmail);
        Event persistedEvent = eventService.addNewStringEvent(eventId);
        //**addNewEvent in EventService has EventRecord type

        String newCustomerEmail = "erica.muse.new@mykenzie.snhu.edu";

        CreateEventRequest createEventRequest = new CreateEventRequest();
        //createEventRequest.setEventId(Optional.of(eventId));
        createEventRequest.setDate(Optional.of(date));
        createEventRequest.setStatus(Optional.of(status));
        createEventRequest.setCustomerName(Optional.of(customerName));
        createEventRequest.setCustomerEmail(Optional.of(newCustomerEmail));

        mapper.registerModule(new JavaTimeModule());

        mvc.perform(put("/events")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(createEventRequest)))

                .andExpect(jsonPath("eventId")
                        .exists())
                .andExpect(jsonPath("date")
                        .value(is(date)))
                .andExpect(jsonPath("status")
                        .value(is(status)))
                .andExpect(jsonPath("customerName")
                        .value(is(customerName)))
                .andExpect(jsonPath("customerEmail")
                        .value(is(newCustomerEmail)))
                .andExpect(status().isOk());
=======
        String customerName = "Sarah";
        String customerEmail = "email";

        Event event = new Event(eventId,customerName,customerEmail,date,status);
        eventService.addNewEvent(event);

        CreateEventRequest request = new CreateEventRequest();
        request.setCustomerName("Shara Smith");
        request.setCustomerEmail("shara@email.com");
        request.setEventId(eventId);

        mapper.registerModule(new JavaTimeModule());

        String json = mapper.writeValueAsString(request);


        mvc.perform(put("/events/{eventId}", eventId)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(jsonPath("$.customerName", is("Shara Smith")))
                .andExpect(jsonPath("$.customerEmail", is("shara@email.com")))
                .andExpect(status().is2xxSuccessful());
        eventService.deleteEvent(eventId);
>>>>>>> origin/main
    }

    @Test
    public void deleteEvent_DeleteSuccessful() throws Exception{
        String eventId = UUID.randomUUID().toString();
        String date = LocalDate.now().toString();
        String status = "upcoming";
<<<<<<< HEAD
        String customerName = "Sarah";
        String customerEmail = "sarah_event_planner@gmail.com";

        Event event = new Event(eventId,date,status,customerName,customerEmail);
        Event persistedEvent = eventService.addNewStringEvent(String.valueOf(event));
        //**addNewEvent in EventService has EventRecord type

        mvc.perform(delete("/events/{eventId}", persistedEvent.getEventId())
                .accept(MediaType.APPLICATION_JSON))

                .andExpect(status().isNoContent());
                assertThat(eventService.findEventById(eventId)).isNull();
                //EventService needs findByEventId method
=======
        String customerName = "Fiona";
        String customerEmail = "Fiona&Shrek@forver.after.com";

        Event event = new Event(eventId,customerName,customerEmail,date,status);
        eventService.addNewEvent(event);

        mvc.perform(delete("/events/{eventId}", eventId)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
>>>>>>> origin/main
    }

}