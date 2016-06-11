package org.nn.sc.empty.jet.dao;

import java.util.List;
import java.util.Vector;

import org.nn.sc.empty.jet.Flight;

public class FlightsDAO {

	private JpaDAO<Flight> dao;
	
	public FlightsDAO(){
		dao = new JpaDAO<Flight>() {};
	}
	
	public void persistFlights(Vector<Flight> flights){
		for(Flight f : flights){
			dao.persist(f);
		}
	}
	
	public List<Flight> loadFlights(){
		return dao.findAll();
		
	}
}
