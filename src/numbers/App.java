package numbers;

/**
 * Eine Klasse mit Beispielen für Grundrechenarten und Ausgaben zum
 * Verifizieren.
 */

public class App {

	public static void main(String[] args) {

		System.out.println("Einige Berechnungen mit der Klasse Rational");
		System.out.println("Testen Sie Ihre Kenntnisse im Bruchrechnen!");
		System.out.println("\nAddition");

		/**
		 * Ein Beispiel für die Addition: Es werden drei Rationale Zahlen erzeugt. Als
		 * Ergebnis sollen die ersten beiden addiert werden. Hierfür wird die erste Zahl
		 * erneut als dritte Zahl erzeugt und zu dieser dritten Zahl wird die zweite
		 * addiert an Hand einer Methode der Rational Klasse. Anschließend werden die
		 * beiden ersten Zahlen und das Ergebnis ausgegeben.
		 */

		Rational b = new Rational(3, 7);
		Rational c = new Rational(2, 6);
		Rational ergebnis = new Rational(3, 7);

		ergebnis.add(c);
		System.out.println(b + "+" + c + " = " + ergebnis);

		Rational z = new Rational(10, 25);
		Rational x = new Rational(13, 16);
		Rational y = z.add(z, x);

		System.out.println(z + "+" + x + " = " + y);

		/**
		 * Ein Beispiel für die Subtraktion: Auch hier werden drei rationale Zahlen
		 * erzeugt. Dier erste Zahl wird erneut auch als dritte Zahl erzeugt und von
		 * dieser wir die zweite Zahl mit Hilfe einer Methode der Klasse Rational
		 * abgezogen. Danach werden alle Zahlen ausgegeben.
		 */

		System.out.println("\nSubtraktion");
		b = new Rational(2, 5);
		c = new Rational(13, 16);
		ergebnis = new Rational(2, 5);

		ergebnis.sub(c);
		System.out.println(b + "-" + c + " = " + ergebnis);

		/**
		 * Ein Beispiel für eine Multiplikation: Es werden drei rationale Zahlen
		 * erzeugt. Die erste Zahl wird noch einmal als dritte Zahl erzeugt. Diese
		 * dritte Zahl wird an Hand einer Methode der Klasse Rational mit der ersten
		 * Zahl multipliziert und das Ergebnis ausgegeben.
		 */

		System.out.println("\nMultiplikation");
		b = new Rational(1, 2);
		c = new Rational(1, 5);
		ergebnis = new Rational(b);

		ergebnis.mul(c);
		System.out.println(b + "*" + c + " = " + ergebnis);

		/**
		 * Ein Beispiel für eine Division: Hier werden zwei rationale Zahlen erzeugt.
		 * Diese werden anschließend dividiert mit Hifle einer Methode der Klasse
		 * Rational. Das Ergebnis wird anschließen ausgegeben.
		 * 
		 * Anschließen wird mit einer weiteren Methoder der Klasse Rational der Kehrwert
		 * des Ergebnisses gebildet.
		 */

		System.out.println("\nDivision");
		ergebnis = new Rational(b);
		Rational a = new Rational(3, 4);
		ergebnis.div(a);
		System.out.println(b + " / " + a + " = " + ergebnis);

		System.out.println("\nKehrwert bilden");
		System.out.println("Wir bilden den Kehrwert von " + ergebnis);
		ergebnis.kehrwert();
		System.out.println("Der Kehrwert ist " + ergebnis);

		/**
		 * Hier wird eine rationale Zahl erzeugt, die anschließen ald Double-Wert
		 * ausgegeben wird.
		 */

		System.out.println("\nDezimalbruch bilden");
		b = new Rational(1, 3);
		System.out.println("Der Dezimalbruch als double-Zahl zu " + b + " ist " + b.getDoubleWert());
	}
}

/**
 * \mainpage ZahlenAufgabe
 * 
 * @autor Etienne Dehm
 * 
 *        Ein Beispiel für ein Java-Projekt für die Lehrveranstaltung
 *        Software-Management Grundlagen im Studiengang IT-Analyst. Dieses
 *        Repository ist der Ausgangspunkt für die Prüfungsleistung und wird von
 *        den Studierenden in einem eigenen repo weiter bearbeitet.
 * 
 *        In diesem Projekt werden diverse Grundrechenarten durchgeführt an Hand
 *        von Grundschularithmetik und rationalen Zahlen.
 * 
 *        Dieser Text befindet sich in der Datei App.java.
 */