package fr.estia.pandora.model;

import java.util.HashMap;
import java.util.Map;

public class Analysis {
	private Map<String, String> featureValues ;
	private int flightDuration ;
	
	private Flight flight ;
	
	
	/**
	 * Constructor, create a basic analysis 
	 * @param flight
	 */
	public Analysis( Flight flight ) {		
		this.flight = flight ;
		this.featureValues = new HashMap<String, String> () ; 
		computeFlightDuration() ;
	} 
	
	private void computeFlightDuration() {
		int startTime, endTime ; 
		startTime = flight.getRecords().get( 0 ).getTimestamp() ; 
		endTime = flight.getRecords().get( flight.getRecords().size() -1 ) .getTimestamp() ;
		setFlightDuration(endTime - startTime) ;
	}

	public int getFlightDuration() {
		return flightDuration;
	}

	public void setFlightDuration(int flightDuration) {
		this.flightDuration = flightDuration;
		this.featureValues.put( "flightDuration", String.valueOf( flightDuration ) ) ;
	}	
	public String getFeatureValue( String feature ) {
		String value = "" ; 
		if( featureValues.containsKey( feature ) ) {
			value = featureValues.get( feature ) ; 
		}
		return value ; 
	}
	
	@Override
	public String toString() {
		String description = "" ;
		for (String feature : featureValues.keySet() ) {
			description += feature + ": " + featureValues.get( feature ) + "\n"; 			
		}
		return description;
	}
}
