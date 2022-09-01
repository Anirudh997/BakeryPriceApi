package com.abhinav.bakeryapi.service;

import com.abhinav.bakeryapi.config.DeliveryConfig;
import com.abhinav.bakeryapi.entities.Offer;
import com.abhinav.bakeryapi.entities.OrderItems;
import com.abhinav.bakeryapi.entities.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BakeryService {


    public String greeting(){
        return "Hi Potti";
    }



    public String getBakeRequest() {
        List<OrderItems> orderItemsList = new ArrayList<>();

        OrderItems orderItems = new OrderItems();
        OrderItems orderItems2 = new OrderItems();
        Offer offer = new Offer();

        Request apiRequest = new Request();

        orderItems.setName("Bread");
        orderItems.setQuantity(2);
        orderItems.setPrice(2200);


        orderItems2.setName("Butter");
        orderItems2.setQuantity(1);
        orderItems2.setPrice(5900);

        orderItemsList.add(orderItems);
        orderItemsList.add(orderItems2);

        offer.setOffer_val(1000);
        offer.setOffer_type("FLAT");

        apiRequest.setDistance(1200);
        apiRequest.setOffer(offer);
        apiRequest.setOrderItemsList(orderItemsList);

        return apiRequest.toString();
    }

    public int getOrderTotal(Request request) throws Exception {
        int sum=0;
        int deliveryfees=0;

        //Adding total price of the products
        if(!request.getOrderItemsList().isEmpty()) {
            for (OrderItems i : request.getOrderItemsList()) {
                sum = sum + i.getPrice() * i.getQuantity();
            }
        }else throw new Exception("no Items");

        //Adding delivery fees
        DeliveryConfig deliveryConfig = new DeliveryConfig();
        deliveryfees = deliveryConfig.getDelivery_price(request.getDistance());
        sum = sum + deliveryfees;

        //Checking offer type and implying discount
        if(!request.getOffer().getOffer_type().isEmpty() && request.getOffer().getOffer_type().equalsIgnoreCase("FLAT")){
            sum = sum - request.getOffer().getOffer_val();
        }

        if(!request.getOffer().getOffer_type().isEmpty() && request.getOffer().getOffer_type().equalsIgnoreCase("DELIVERY")){
            sum = sum - deliveryfees;
        }

        return sum;
    }
}
