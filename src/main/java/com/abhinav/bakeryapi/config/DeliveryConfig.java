package com.abhinav.bakeryapi.config;

public class DeliveryConfig {

    public int getDelivery_price(int distance){
        if(distance<=10000) return 5000;
        else if(distance > 10001 && distance <= 20000) return 10000;
        else if(distance > 20001 && distance <= 50000) return 50000;
        else return 100000;
    }

}
