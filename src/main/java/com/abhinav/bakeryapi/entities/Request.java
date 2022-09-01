package com.abhinav.bakeryapi.entities;

import java.util.List;

public class Request {

    public Request(){

    }

    private List<OrderItems> orderItemsList;
    private int distance;
    private Offer offer;

    @Override
    public String toString() {
        return "Request{" +
                "orderItemsList=" + orderItemsList +
                ", distance=" + distance +
                ", offer=" + offer +
                '}';
    }

    public Request(List<OrderItems> orderItemsList, int distance, Offer offer) {
        this.orderItemsList = orderItemsList;
        this.distance = distance;
        this.offer = offer;
    }

    public List<OrderItems> getOrderItemsList() {
        return orderItemsList;
    }

    public void setOrderItemsList(List<OrderItems> orderItemsList) {
        this.orderItemsList = orderItemsList;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }


}
