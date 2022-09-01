package com.abhinav.bakeryapi.controller;

import com.abhinav.bakeryapi.entities.ApiResponse;
import com.abhinav.bakeryapi.entities.Request;
import com.abhinav.bakeryapi.service.BakeryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BakeryController {

    @Autowired
    private BakeryService bakeryService;

    @GetMapping
    public String getMessage(){
        return bakeryService.greeting();
    }

    @GetMapping("/getbake")
    public String getRequest(){
        return bakeryService.getBakeRequest();
    }

    @GetMapping("/sum")
    public ResponseEntity<ApiResponse> getTotalPrice(@RequestBody Request request) throws Exception {
        ApiResponse response = new ApiResponse();
        response.setOrderTotal(bakeryService.getOrderTotal(request));
        return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
    }

}
