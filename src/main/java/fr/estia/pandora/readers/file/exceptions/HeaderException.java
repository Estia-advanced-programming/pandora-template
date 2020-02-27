package fr.estia.pandora.readers.file.exceptions;

public class HeaderException extends FlightRecordException {
	/** An id for serialization purpose */
	private static final long serialVersionUID = -3886159525507073605L;
	String message ; 
	public HeaderException(String message) {
		this.message = message ; 
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage() + this.message ;
	}
}
