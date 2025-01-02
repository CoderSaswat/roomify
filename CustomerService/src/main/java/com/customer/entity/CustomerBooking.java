package com.customer.entity;

import lombok.AllArgsConstructor;

import java.util.List;

public class CustomerBooking {
    private Customer customer;
    private List<Booking> bookingList;

    public CustomerBooking(Customer customer, List<Booking> bookingList) {
        this.customer = customer;
        this.bookingList = bookingList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

}
