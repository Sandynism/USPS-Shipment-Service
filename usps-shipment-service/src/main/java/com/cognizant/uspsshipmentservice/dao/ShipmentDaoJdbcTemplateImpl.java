package com.cognizant.uspsshipmentservice.dao;

import com.cognizant.uspsshipmentservice.model.Shipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ShipmentDaoJdbcTemplateImpl implements ShipmentDao {

    private static final String SELECT_SHIPMENT_BY_TRACKING_NUMBER_SQL =
            "select * from shipment where tracking_number = ?";

    private static final String INSERT_SHIPMENT_SQL =
            "insert into shipment (customer_name, tracking_number) values(?, ?)";

    private static final String SELECT_ALL_SHIPMENTS_SQL =
            "select * from shipment";

    private static final String DELETE_SHIPMENT_SQL =
            "delete from shipment where shipment_id =?";

    private static final String SELECT_SHIPMENT_BY_SHIPMENT_ID_SQL =
            "select * from shipment where shipment_id = ?";

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ShipmentDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private Shipment mapRowToShipment(ResultSet rs, int rowNum) throws SQLException {
        Shipment shipment = new Shipment();
        shipment.setShipmentId(rs.getInt("shipment_id"));
        shipment.setCustomerName(rs.getString("customer_name"));
        shipment.setTrackingNumber(rs.getInt("tracking_number"));

        return shipment;
    }

    @Override
    public Shipment getShipmentByTrackingNumber(Integer trackingNumber) {
        return jdbcTemplate.queryForObject(SELECT_SHIPMENT_BY_TRACKING_NUMBER_SQL, this::mapRowToShipment, trackingNumber);
    }


    @Override
    @Transactional
    public Shipment addShipment(Shipment shipment) {
        jdbcTemplate.update(INSERT_SHIPMENT_SQL, shipment.getCustomerName(), shipment.getTrackingNumber());
        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);
        shipment.setShipmentId(id);
        return shipment;
    }

    @Override
    public List<Shipment> getAllShipments() {
        return jdbcTemplate.query(SELECT_ALL_SHIPMENTS_SQL, this::mapRowToShipment);
    }

    @Override
    public void deleteShipment(Integer shipmentId) {
        jdbcTemplate.update(DELETE_SHIPMENT_SQL, shipmentId);
    }

    @Override
    public Shipment getShipmentByShipmentId(Integer shipmentId) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SHIPMENT_BY_SHIPMENT_ID_SQL, this::mapRowToShipment, shipmentId);
        } catch (EmptyResultDataAccessException | NullPointerException e) {
            return null;
        }
    }
}
