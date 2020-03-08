package fr.estia.pandora.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <@dhmmasson> 
 * Generic Analysis, you should create specialized analysis that extends this 
 */
public class Analysis {
	private Flight flight ;
	private Map<String, String> featureValues ;
	//List of feature computed by this analysis 
	private int flightDuration ;	
	
	
	
	/**
	 * Constructor, create a basic analysis 
	 * @param flight
	 */
	public Analysis( Flight flight ) {		
		this.flight = flight ;
		this.featureValues = new HashMap<String, String> () ; 
		computeFlightDuration() ;
	} 
	
	public String getFeatureValue( String feature ) {
		String value = "" ; 
		if( featureValues.containsKey( feature ) ) {
			value = featureValues.get( feature ) ; 
		}
		return value ; 
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
	
	@Override
	public String toString() {
		String description = "" ;
		for (String feature : featureValues.keySet() ) {
			description += feature + ": " + featureValues.get( feature ) + "\n"; 			
		}
		return description;
	}
}
