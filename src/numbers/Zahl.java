package numbers;

/**
 * Eine abstrake Klasse für die Grundschularithmetik mit Zahlen.
 */

public abstract class Zahl {
	
	/**
	 * Eine Liste von Methoden für Rechenarten mit Zahlen bzw. deren Ausgabe.
	 */
	
	 //Jede Zahl sollte mit den 4 Grundrechenarten bearbeitet werden können.	
	 public abstract void add(Zahl a);
	 
	 public abstract void sub(Zahl z);
	 
	 public abstract void mul(Zahl z);
	 
	 public abstract void div(Zahl z);	 
	 
	 //Anzeigen der Zahl sollte auch möglich sein.
	 public abstract void print();
}
