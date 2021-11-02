package com.cg.niit.flightbooking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.niit.flightbooking.entity.FlightDetails;
public interface FlightDetailsRepository extends JpaRepository<FlightDetails,Integer> 
{

}
