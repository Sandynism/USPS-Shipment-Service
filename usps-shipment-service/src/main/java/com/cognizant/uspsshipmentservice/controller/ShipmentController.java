package com.cognizant.uspsshipmentservice.controller;

import com.cognizant.uspsshipmentservice.dao.ShipmentDao;
import com.cognizant.uspsshipmentservice.exception.NotFoundException;
import com.cognizant.uspsshipmentservice.model.Shipment;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RefreshScope
@RequestMapping(value = "/shipment")
public class ShipmentController {

    @Autowired
    ShipmentDao shipmentDao;

    @GetMapping(value = "/{trackingnumber}")
    @ResponseStatus(HttpStatus.OK)
    public Shipment getShipmentByTrackingNumber(@PathVariable(name = "trackingnumber") Integer trackingNumber) {
        Shipment shipment = shipmentDao.getShipmentByTrackingNumber(trackingNumber);

        if (shipment == null)
            throw new NotFoundException("Shipment with tracking number " + trackingNumber + " could not be found.");
//            return null;

        return shipment;
    }

    @PostMapping(value = "/addshipment")
    @ResponseStatus(HttpStatus.CREATED)
    public Shipment addShipment(@RequestBody @Valid Shipment shipment) {
        return shipmentDao.addShipment(shipment);
    }


    // Shipment getShipmentByTrackingNumber(Integer trackingNumber);
    //
    //    Shipment addShipment(Shipment shipment);
    //
    //    List<Shipment> getAllShipments();
    //
    //    void deleteShipment(Integer shipmentId);
    //
    //    Shipment getShipmentByShipmentId(Integer shipmentId);
}
