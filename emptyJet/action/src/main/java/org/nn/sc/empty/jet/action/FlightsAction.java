package org.nn.sc.empty.jet.action;

import java.util.List;
import java.util.Vector;

import org.nn.sc.empty.jet.Flight;
import org.nn.sc.empty.jet.dao.FlightsDAO;

public class FlightsAction {

	private Vector<Flight> flights;
	
	public FlightsAction(){
		flights = new Vector<Flight>();
	}
	
	public void addFlights(){
		FlightsDAO dao = new FlightsDAO();
		Flight f1 = new Flight("Paris", "Genève");
		Flight f2 = new Flight("Beirut", "Dubai");
		flights.add(f1);
		flights.add(f2);
		dao.persistFlights(flights);
	}
	
	public List<Flight> loadFlights(){
		FlightsDAO dao = new FlightsDAO();
		return dao.loadFlights();
	}
	
}
