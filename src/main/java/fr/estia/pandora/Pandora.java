
package fr.estia.pandora;


import fr.estia.pandora.model.Analysis;
import fr.estia.pandora.model.Flight;
import fr.estia.pandora.printer.ConsolePrinter;
import fr.estia.pandora.printer.FeaturePrinter;
import fr.estia.pandora.readers.commandLine.CLI;
import fr.estia.pandora.readers.commandLine.exceptions.NoOpException;
import fr.estia.pandora.readers.commandLine.exceptions.OptionException;
import fr.estia.pandora.readers.file.FileReader;
import fr.estia.pandora.readers.file.exceptions.FlightRecordException;


/**
 * @author William Delamare
 * @author Dimitri Masson
 *
 */
public class Pandora {	
	static final int EXIT_OK = 0 ;
	static final int EXIT_ILLEGAL_ARGUMENT = -1 ; 
	static final int EXIT_INVALID_FLIGHT_RECORD = -2 ;

	public static void main(String[] arguments) {		
		try {

			CLI.configure( "Pandora", 1, 0, 0 ) ;
			CLI.read( arguments ) ;						
			FileReader fileReader = new FileReader( "./" ) ;			


			for (String source :  CLI.getConfiguration().getSources()) {
				Flight currentFlight = fileReader.GetRecordsFromFile( source ) ;							
				Analysis analysis = new Analysis( currentFlight ) ;			
				print( currentFlight, analysis ) ;
			}			


		} catch (OptionException e) {
			System.out.println( e.getMessage() );
			System.exit( EXIT_ILLEGAL_ARGUMENT );		
		} catch (FlightRecordException e) {
			System.out.println( e.getMessage() );
			System.exit( EXIT_INVALID_FLIGHT_RECORD );		
		} catch (NoOpException e) {
			System.exit( EXIT_OK );			
		} 
	}

	static void print( Flight flight, Analysis analysis ) {
		switch (CLI.getConfiguration().getOutputMode()) {
		case feature :
			FeaturePrinter.setTargetFeature( CLI.getConfiguration().getTargetFeature() ) ; 
			FeaturePrinter.print(flight, analysis);
			break ; 
		default : 
			ConsolePrinter.print( flight, analysis );
		}
	}
}