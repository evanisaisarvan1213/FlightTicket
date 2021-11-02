package com.cg.niit.flightbooking.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.niit.flightbooking.entity.FlightDetails;
import com.cg.niit.flightbooking.repository.FlightDetailsRepository;
@Service
public class FlightDetailsService 
{
	@Autowired
	FlightDetailsRepository flightDetailsRepository;
	
	@Transactional(readOnly=true)
	public FlightDetails getFlightDetails(int flightNumber)
	{
		Optional<FlightDetails> fdetails = flightDetailsRepository.findById(flightNumber);
		if(fdetails!=null)
			return fdetails.get();
		throw new RuntimeException("No Flight Found");
	}
	
	@Transactional(readOnly=true)
	public List<FlightDetails> getFlightsDetails()
	{
		List<FlightDetails> fdlist = flightDetailsRepository.findAll();
		if(fdlist.size()>0)
			return fdlist;
		throw new RuntimeException("No Flight Found");
	}
	
}
