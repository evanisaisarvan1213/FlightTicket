package com.cg.niit.flightbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.niit.flightbooking.entity.PassengerDetails;
import com.cg.niit.flightbooking.repository.PassengerDetailsRepository;

@Service
public class PassengerDetailsService 
{
	@Autowired
	PassengerDetailsRepository passengerRepository;
	
	@Transactional(readOnly=true)
	public PassengerDetails getPassenger(int passengerId)
	{
		Optional<PassengerDetails> pdetails = passengerRepository.findById(passengerId);
		if(pdetails!=null)
			return pdetails.get();
		throw new RuntimeException("No Passenger Found");
	}
	
	@Transactional(readOnly=true)
	public List<PassengerDetails> getPassengers()
	{
		List<PassengerDetails> plist = passengerRepository.findAll();
		if(plist.size()>0)
			return plist;
		throw new RuntimeException("No Passengers Found");
	}
	
	@Transactional
	public boolean getCancelTickets(String status,int bookingId)
	{
		int count=passengerRepository.cancelTicketBooked(status,bookingId);
		System.out.println(count);
		return count==1;
	}
	
	@Transactional
	public boolean addPassengerDetails(PassengerDetails passengerDetails)
	{
		PassengerDetails passenger = passengerRepository.save(passengerDetails);
		return passenger!=null;
	}
	
}
