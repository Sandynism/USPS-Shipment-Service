package com.cognizant.uspsshipmentservice.dao;

import com.cognizant.uspsshipmentservice.model.Shipment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ShipmentDaoTest {

    private static final Integer SHIPMENT_ID = 1;
    private static final Shipment SHIPMENT_INPUT1 = new Shipment("Mary Smith", 778335);
    private static final Shipment SHIPMENT_OUTPUT1 = new Shipment(1,"Mary Smith", 778335);
    private static final Shipment SHIPMENT_INPUT2 = new Shipment("John Doe", 551328);
    private static final Shipment SHIPMENT_OUTPUT2 = new Shipment(2,"John Doe", 551328);


    @Autowired
    ShipmentDao shipmentDao;

    @Before
    public void setUp() throws Exception {
        shipmentDao.getAllShipments().stream().forEach(s -> shipmentDao.deleteShipment(s.getShipmentId()));
    }

    @Test
    public void getShipmentByTrackingNumber() {
        Shipment shipment = shipmentDao.addShipment(SHIPMENT_INPUT1);
        Shipment shipment2 = shipmentDao.getShipmentByTrackingNumber(778335);

        assertEquals(shipment, shipment2);
    }

    @Test
    public void addGetDeleteShipment() {
        Shipment shipment = shipmentDao.addShipment(SHIPMENT_INPUT1);
        Shipment shipment2 = shipmentDao.getShipmentByShipmentId(shipment.getShipmentId());

        assertEquals(shipment, shipment2);

        shipmentDao.deleteShipment(shipment.getShipmentId());

        shipment2 = shipmentDao.getShipmentByShipmentId(shipment.getShipmentId());

        assertNull(shipment2);
    }

    @Test
    public void getAllShipments() {
        Shipment shipment = shipmentDao.addShipment(SHIPMENT_INPUT1);
        Shipment shipment2 = shipmentDao.addShipment(SHIPMENT_INPUT2);

        List<Shipment> shipmentsList = shipmentDao.getAllShipments();
        assertEquals(shipmentsList.size(), 2);
    }


}