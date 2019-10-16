package com.cognizant.clientservice.service;

import com.cognizant.clientservice.exception.NotFoundException;
import com.cognizant.clientservice.model.Shipment;
import com.cognizant.clientservice.model.ShipmentViewModel;
import com.cognizant.clientservice.util.feign.ShipmentClient;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

    ShipmentClient shipmentClient;

    @Autowired
    public ServiceLayer(ShipmentClient shipmentClient) {
        this.shipmentClient = shipmentClient;
    }

    public ShipmentViewModel addShipment(ShipmentViewModel svm) {
        Shipment shipment = new Shipment();

        shipment.setCustomerName(svm.getCustomerName());
        shipment.setTrackingNumber(svm.getTrackingNumber());

        shipment = shipmentClient.addShipment(shipment);

        return buildShipmentViewModel(shipment);
    }

    public ShipmentViewModel getShipmentByTrackingNumber(Integer trackingNumber) {
        Shipment shipment = shipmentClient.getShipmentByTrackingNumber(trackingNumber);

        if (shipment == null)
            throw new NotFoundException("Shipment with tracking number " + trackingNumber + " could not be found.");

        return buildShipmentViewModel(shipment);
    }

    private ShipmentViewModel buildShipmentViewModel(Shipment shipment) {
        ShipmentViewModel svm = new ShipmentViewModel();
        svm.setShipmentId(shipment.getShipmentId());
        svm.setCustomerName(shipment.getCustomerName());
        svm.setTrackingNumber(shipment.getTrackingNumber());

        return svm;
    }
}
