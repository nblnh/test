package org.nn.sc.empty.jet.presentation;

import java.util.List;
import java.util.Vector;

import org.nn.sc.empty.jet.Flight;
import org.nn.sc.empty.jet.action.FlightsAction;

import com.opensymphony.xwork2.ActionSupport;

public class Flights extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private List<Flight> flights = new Vector<Flight>();
	
	public String execute(){
		
		FlightsAction action = new FlightsAction();
		action.addFlights();
		flights = action.loadFlights();
		return SUCCESS;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
}
