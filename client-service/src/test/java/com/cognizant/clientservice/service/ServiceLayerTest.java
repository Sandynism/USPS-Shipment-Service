package com.cognizant.clientservice.service;

import com.cognizant.clientservice.model.Shipment;
import com.cognizant.clientservice.model.ShipmentViewModel;
import com.cognizant.clientservice.util.feign.ShipmentClient;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class ServiceLayerTest {

    private static final Integer SHIPMENT_ID = 1;
    private static final Shipment SHIPMENT_INPUT1 = new Shipment("Mary Smith", 778335);
    private static final Shipment SHIPMENT_OUTPUT1 = new Shipment(1,"Mary Smith", 778335);
    private static final Shipment SHIPMENT_INPUT2 = new Shipment("John Doe", 551328);
    private static final Shipment SHIPMENT_OUTPUT2 = new Shipment(2,"John Doe", 551328);
    private static final ShipmentViewModel SHIPMENTVM_INPUT1 = new ShipmentViewModel("Mary Smith", 778335);
    private static final ShipmentViewModel SHIPMENTVM_OUTPUT1 = new ShipmentViewModel(1,"Mary Smith", 778335);

    ServiceLayer sl;
    ShipmentClient sc;


    @Before
    public void setUp() throws Exception {
        setUpShipmentClientMock();

        sl = new ServiceLayer(sc);
    }

    private void setUpShipmentClientMock() {
        sc = mock(ShipmentClient.class);

        //add
        doReturn(SHIPMENT_OUTPUT1).when(sc).addShipment(SHIPMENT_INPUT1);

        //get by tracking
        doReturn(SHIPMENT_OUTPUT1).when(sc).getShipmentByTrackingNumber(778335);
    }



    @Test
    public void addShipmentAndGetShipmentByTrackingNumber() {
        ShipmentViewModel svm = sl.addShipment(SHIPMENTVM_INPUT1);

        ShipmentViewModel fromService = sl.getShipmentByTrackingNumber(778335);

        assertEquals(svm, fromService);
    }


}