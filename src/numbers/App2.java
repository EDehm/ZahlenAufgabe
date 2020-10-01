package numbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Eine Klasse die entsprechend der Aufgabenstellung von Schritt 2 erstellt
 * wurde.
 */

public class App2 {

	public static void main(String[] args) {
		
		final Logger log = LoggerFactory.getLogger(App.class.getName());
		log.info(">> App2.main");

		/**
		 * Es wird ein neues Objekt der Klasse Relational erzeugt und die Methode jener
		 * Klasse aufgerufen.
		 */

		System.out.println("Hier finden Sie die Anwendungsklasse zu Schritt 2 der Abgabe.");
		Rational bruch = new Rational();
		bruch.eingabe();
		
		log.info("<< App2.main");
	}

}
