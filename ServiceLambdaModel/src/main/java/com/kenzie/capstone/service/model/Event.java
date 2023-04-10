package com.kenzie.capstone.service.model;

<<<<<<< HEAD
import java.time.LocalDateTime;
import java.util.Objects;

import static java.util.UUID.randomUUID;
=======
import java.util.Objects;

>>>>>>> origin/main

public class Event {
    private String eventId;
    private String customerName;
<<<<<<< HEAD
    private String eventDate;
    private String eventStatus;
    private String customerEmail;
//
//    //Three constructors, dependent on how we're creating new events. We can delete one in the future
//    public Event(String name, String email) {
//        this.eventId = randomUUID().toString();
//        this.customerName = name;
//        this.customerEmail = email;
//        this.eventDate = LocalDateTime.now().toString();
//        this.eventStatus = "active"; //placeholder until I know what keywords we're using
//    }
//
//    public Event(String name, String email, String date, String status) {
//        this.eventId = randomUUID().toString();
//        this.customerName = name;
//        this.customerEmail = email;
//        this.eventDate = date;
//        this.eventStatus = status;
//    }
=======
    private String date;
    private String eventStatus;
    private String customerEmail;
>>>>>>> origin/main

    public Event(String eventId, String name, String email, String date, String status) {
        this.eventId = eventId;
        this.customerName = name;
        this.customerEmail = email;
<<<<<<< HEAD
        this.eventDate = date;
=======
        this.date = date;
>>>>>>> origin/main
        this.eventStatus = status;
    }

    public Event(){}

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEventDate() {
<<<<<<< HEAD
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
=======
        return date;
    }

    public void setEventDate(String eventDate) {
        this.date = eventDate;
>>>>>>> origin/main
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
<<<<<<< HEAD
        return Objects.equals(eventId, event.eventId) && Objects.equals(customerName, event.customerName) && Objects.equals(eventDate, event.eventDate) && Objects.equals(eventStatus, event.eventStatus) && Objects.equals(customerEmail, event.customerEmail);
=======
        return Objects.equals(eventId, event.eventId) && Objects.equals(customerName, event.customerName) && Objects.equals(date, event.date) && Objects.equals(eventStatus, event.eventStatus) && Objects.equals(customerEmail, event.customerEmail);
>>>>>>> origin/main
    }

    @Override
    public int hashCode() {
<<<<<<< HEAD
        return Objects.hash(eventId, customerName, eventDate, eventStatus, customerEmail);
=======
        return Objects.hash(eventId, customerName, date, eventStatus, customerEmail);
>>>>>>> origin/main
    }

    @Override
    public String toString(){
        return "EventResponse{" +
                "eventId='" + eventId + '\'' +
<<<<<<< HEAD
                ", date='" + eventDate + '\'' +
=======
                ", date='" + date + '\'' +
>>>>>>> origin/main
                ", status=" + eventStatus + '\'' +
                ", customerName=" + customerName + '\'' +
                ", customerEmail=" + customerEmail +
                '}';
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> origin/main
