package com.cognizant.clientservice.controller;

import com.cognizant.clientservice.exception.NotFoundException;
import com.cognizant.clientservice.model.Shipment;
import com.cognizant.clientservice.util.feign.ShipmentClient;
import feign.FeignException;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RefreshScope
@RequestMapping(value = "/clientfe")
public class ClientServiceController {

    @Autowired
    ShipmentClient shipmentClient;

    @GetMapping(value = "/shipment/{trackingnumber}")
    @ResponseStatus(HttpStatus.OK)
    Shipment getShipmentByTrackingNumber(@PathVariable(name = "trackingnumber") Integer trackingNumber) {
        Shipment shipment = shipmentClient.getShipmentByTrackingNumber(trackingNumber);

        if (shipment == null)
            throw new NotFoundException("Shipment with tracking number " + trackingNumber + " could not be found.");

        return shipment;
    }

    @PostMapping(value = "/shipment/addshipment")
    @ResponseStatus(HttpStatus.CREATED)
    Shipment addShipment(@RequestBody @Valid Shipment shipment) {
        return shipmentClient.addShipment(shipment);
    }
}
