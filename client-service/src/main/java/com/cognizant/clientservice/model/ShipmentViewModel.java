package com.cognizant.clientservice.model;

import java.util.Objects;

public class ShipmentViewModel {
    private Integer shipmentId;
    private String customerName;
    private Integer trackingNumber;

    public ShipmentViewModel() {
    }

    public ShipmentViewModel(Integer shipmentId, String customerName, Integer trackingNumber) {
        this.shipmentId = shipmentId;
        this.customerName = customerName;
        this.trackingNumber = trackingNumber;
    }

    public ShipmentViewModel(String customerName, Integer trackingNumber) {
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
        if (!(o instanceof ShipmentViewModel)) return false;
        ShipmentViewModel that = (ShipmentViewModel) o;
        return Objects.equals(getShipmentId(), that.getShipmentId()) &&
                Objects.equals(getCustomerName(), that.getCustomerName()) &&
                Objects.equals(getTrackingNumber(), that.getTrackingNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getShipmentId(), getCustomerName(), getTrackingNumber());
    }
}
