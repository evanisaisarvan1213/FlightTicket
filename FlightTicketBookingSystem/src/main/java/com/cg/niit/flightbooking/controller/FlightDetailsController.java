package com.cg.niit.flightbooking.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.niit.flightbooking.entity.FlightDetails;
import com.cg.niit.flightbooking.service.FlightDetailsService;

@RestController
@RequestMapping("/FlightDetails")
public class FlightDetailsController 
{
	@Autowired
	FlightDetailsService fdetailsService;
	
	@GetMapping(value="/{flightNumber}",produces="application/json")
	public ResponseEntity<FlightDetails> getFdetails(@PathVariable int flightNumber)
	{
		FlightDetails fdetails = fdetailsService.getFlightDetails(flightNumber);
		return new ResponseEntity<FlightDetails>(fdetails,HttpStatus.OK);
	}
	
	@GetMapping(produces="application/json")
	public ResponseEntity<List<FlightDetails>> getFlightsDetails()
	{
		return new ResponseEntity<List<FlightDetails>>(fdetailsService.getFlightsDetails(),HttpStatus.OK);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
}
