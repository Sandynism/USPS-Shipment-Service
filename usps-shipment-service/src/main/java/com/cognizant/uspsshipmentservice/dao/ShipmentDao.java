package com.cognizant.uspsshipmentservice.dao;

import com.cognizant.uspsshipmentservice.model.Shipment;

import java.util.List;

public interface ShipmentDao {
    Shipment getShipmentByTrackingNumber(Integer trackingNumber);

    Shipment addShipment(Shipment shipment);

    List<Shipment> getAllShipments();

    void deleteShipment(Integer shipmentId);

    Shipment getShipmentByShipmentId(Integer shipmentId);

}

