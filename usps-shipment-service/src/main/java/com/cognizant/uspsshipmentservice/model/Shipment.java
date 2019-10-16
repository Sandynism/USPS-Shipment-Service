package com.cognizant.uspsshipmentservice.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Shipment {
    private Integer shipmentId;
    @NotEmpty(message = "Customer name cannot be empty.")
    private String customerName;
    //    @Size(min=6, max=6, message="Tracking number must be 6 integers long.")
    @NotNull(message = "Tracking number must be 6 characters.")
    private Integer trackingNumber;

    public Shipment() {
    }

    public Shipment(Integer shipmentId, String customerName, Integer trackingNumber) {
        this.shipmentId = shipmentId;
        this.customerName = customerName;
        this.trackingNumber = trackingNumber;
    }

    public Shipment(String customerName, Integer trackingNumber) {
        this.customerName = customerName;
        this.trackingNumber = trackingNumber;
    }

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
        if (!(o instanceof Shipment)) return false;
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

