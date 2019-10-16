package com.cognizant.clientservice.model;

import java.util.Objects;

public class Shipment {
    private Integer shipmentId;
    private String customerName;
    private Integer trackingNumber;

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(Integer trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shipment shipment = (Shipment) o;
        return Objects.equals(getShipmentId(), shipment.getShipmentId()) &&
                Objects.equals(getCustomerName(), shipment.getCustomerName()) &&
                Objects.equals(getTrackingNumber(), shipment.getTrackingNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShipmentId(), getCustomerName(), getTrackingNumber());
    }
}
