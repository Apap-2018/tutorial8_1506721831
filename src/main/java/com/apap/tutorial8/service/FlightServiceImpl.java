package com.apap.tutorial8.service;

import java.util.Optional;

import com.apap.tutorial8.model.FlightModel;
import com.apap.tutorial8.repository.FlightDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * FlightServiceImpl
 */
@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightDB flightDB;
    
    @Override
    public FlightModel addFlight(FlightModel flight) {
        return flightDB.save(flight);
    }

    @Override
    public void deleteByFlightNumber(String flightNumber) {
        flightDB.deleteByFlightNumber(flightNumber);
    }

    @Override
    public Optional<FlightModel> getFlightDetailByFlightNumber(String flightNumber) {
        return flightDB.findByFlightNumber(flightNumber);
    }
}