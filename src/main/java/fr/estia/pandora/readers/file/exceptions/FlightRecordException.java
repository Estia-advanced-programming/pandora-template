package fr.estia.pandora.readers.file.exceptions;

public class FlightRecordException extends Exception {
	/** An id for serialization purpose */
	private static final long serialVersionUID = -5255255831476166381L;
	private String message ; 
	public FlightRecordException( String message ) {
		this.message = message ; 
	}
	public FlightRecordException() {
		this( "" ) ; 
	}
	@Override
	public String getMessage() {		
		return "Invalid Flight Record: " + message  ;
	}

}