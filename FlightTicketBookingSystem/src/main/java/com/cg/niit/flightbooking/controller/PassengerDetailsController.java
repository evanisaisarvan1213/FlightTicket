package com.cg.niit.flightbooking.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.niit.flightbooking.entity.PassengerDetails;
import com.cg.niit.flightbooking.service.PassengerDetailsService;
@RestController
@RequestMapping("/Passenger")
public class PassengerDetailsController 
{
	@Autowired
	PassengerDetailsService passengerService;
	
	@PostMapping(consumes="application/json")
	public HttpStatus getPassengerDetails(PassengerDetails passengerDetails)
	{
		if(passengerService.addPassengerDetails(passengerDetails))
			return HttpStatus.CREATED;
		 return HttpStatus.NOT_ACCEPTABLE;	
	}
	
	@PutMapping(value="/{status}/{bookingId}")
	public HttpStatus getTicketdCanceled(@PathVariable String status,@PathVariable int bookingId)
	{
		if(passengerService.getCancelTickets(status, bookingId))
			return HttpStatus.OK;
		return HttpStatus.NOT_MODIFIED;
			
	}
	
	@ExceptionHandler(RuntimeException.class)
	public HttpStatus exceptionHandlerMethod()
	{
		return HttpStatus.NO_CONTENT;
	}
}
