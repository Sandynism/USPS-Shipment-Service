package com.cognizant.clientservice.util.feign;

import com.cognizant.clientservice.model.Shipment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "usps-shipment-service")
public interface ShipmentClient {

    @GetMapping(value = "/shipment/{trackingnumber}")
    Shipment getShipmentByTrackingNumber(@PathVariable(name = "trackingnumber") Integer trackingNumber);

    @PostMapping(value = "/shipment/addshipment")
    Shipment addShipment(@RequestBody Shipment shipment);
}
