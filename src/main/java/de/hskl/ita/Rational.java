package de.hskl.ita;

/**
 * Eine Klasse für rationale Zahlen, die als Bruch aus ganzen Zahlen realisiert werden.
 * Sie wird abgeleitet von der Klasse Zahl.
 */

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rational extends Zahl {

	final Logger logger = LoggerFactory.getLogger(Rational.class.getName());

	private int p;
	private int q;

	/**
	 * Ein Objekt der Klasse ohne Vorgabe einer Zahl wird mit dem Wert 1 erstellt
	 * für den Zähler, als auch den Nenner.
	 * 
	 */

	public Rational() {
		logger.trace(">> Rational()");
		this.p = 1;
		this.q = 1;
		logger.info("** Rationale Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< Rational()");
	}

	/**
	 * Ein Objekt der Klasse mit Vorgabe einer Zahl wird mit dem Wert der Vorgabe
	 * als Zähler und dem Wert 1 als Nenner erstellt.
	 * 
	 * \param[in] z die Vorgabe für den p-Wert, dem Zähler.
	 */

	public Rational(int z) {
		logger.trace(">> Rational(int)");
		this.p = z;
		this.q = 1;
		logger.info("** Rationale Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< Rational(int)");
	}

	/**
	 * Ein Objekt der Klasse mit Vorgabe zweier Zahlen wird mit dem Wert der ersten
	 * Vorgabe als Zähler und dem Wert der zweiten Vorgabe als Nenner erstellt.
	 * 
	 * \param[in] z die Vorgabe für den p-Wert, dem Zähler. \param[in] n die Vorgabe
	 * für den q-Wert, dem Nenner.
	 */

	public Rational(int z, int n) {
		logger.trace(">> Rational(int, int)");
		this.p = z;
		this.q = n;
		assert (n != 0);
		kuerzen();
		logger.info("** Ungekürzte rationale Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< Rational(int, int)");
	}

	/**
	 * Ein neues Objekt wird aus einem anderen Objekt der Klasse Rational erzeugt.
	 * 
	 * \param[in] other es wird aus dem Objekt der Zähler und der Nenner übernommen.
	 */

	public Rational(Rational other) {
		this(other.zaehler(), other.nenner());
	}

	/**
	 * Es wird definiert wie ein Objekt der Klasse ausgegeben wird als Text.
	 * 
	 * \param p der Wert des Zählers. \param q der Wert des Nenners.
	 */

	public void print() {
		System.out.println(p + "/" + q);
	}

	@Override
	public String toString() {
		String text = "";
		text = String.valueOf(p) + "/" + String.valueOf(q);
		return text;
	}

	/**
	 * Liefert den Zähler des Objekts.
	 * 
	 * \return der Zähler des Objekts.
	 */

	public int zaehler() {
		return p;
	}

	/**
	 * Liefert den Nenner des Objekts.
	 * 
	 * \return der Nenner des Objekts.
	 */

	public int nenner() {
		return q;
	}

	/**
	 * Wandelt eine Objekt der Klasse Zahl in eins der Klasse Rational um und
	 * addiert diese dann zum Objekt. Anschließend wird das Ergebnis gekürzt.
	 * 
	 * \param[in] z die zu addierende Zahl. \param local die zu addierende Zahl als
	 * rationale Zahl. \param p der Zähler der Summe. \param q der Nenner der Summe.
	 */

	public void add(Zahl z) {
		logger.trace(">> add(Zahl)");
		Rational local = (Rational) z;
		p = p * local.q + local.p * q;
		q = q * local.q;
		kuerzen();
		logger.info("** Ungekürzte addierte Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< add(Zahl)");
	}

	/**
	 * Wandelt eine Integer Zahl in ein Objekt der Klasse Rational um und addiert
	 * diese zum Objekt. Anschließend wird das ergebnis gekürzt.
	 * 
	 * \param[in] i der zu addierende Integer Wert. \param local der Integer Wert
	 * als rationale Zahl.
	 */

	public void add(int i) {
		logger.trace(">> add(int)");
		Rational local = new Rational(i);
		add(local);
		kuerzen();
		logger.trace("<< add(int)");
	}

	/**
	 * Wandelt eine Objekt der Klasse Zahl in eins der Klasse Rational um und
	 * subtrahiert diese dann vom Objekt. Anschließend wird das Ergebnis gekürzt.
	 * 
	 * \param[in] z die zu subtrahierende Zahl. \param local die zu subtrahierende
	 * Zahl als rationale Zahl. \param p der Zähler der Subtraktion. \param q der
	 * Nenner der Subtraktion.
	 */

	public void sub(Zahl z) {
		logger.trace(">> sub(Zahl)");
		Rational local = (Rational) z;
		p = p * local.q - local.p * q;
		q = q * local.q;
		kuerzen();
		logger.info("** Ungekürzte subtrahierte Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< sub(Zahl)");
	}

	/**
	 * Wandelt eine Integer Zahl in ein Objekt der Klasse Rational um und
	 * subtrahiert diese vom Objekt. Anschließend wird das Ergebnis gekürzt.
	 * 
	 * \param[in] i der zu subtrahierende Integer Wert. \param local der Integer
	 * Wert als rationale Zahl.
	 */

	public void sub(int i) {
		logger.trace(">> sub(int)");
		Rational local = new Rational(i);
		sub(local);
		kuerzen();
		logger.trace("<< sub(int)");
	}

	/**
	 * Wandelt eine Objekt der Klasse Zahl in eins der Klasse Rational um und
	 * multipliziert diese dann mit dem Objekt. Anschließend wird das Ergebnis
	 * gekürzt.
	 * 
	 * \param[in] z die zu multiplizierende Zahl. \param local die zu
	 * multiplizierende Zahl als rationale Zahl. \param p der Zähler der
	 * Multiplikation. \param q der Nenner der Multiplikation.
	 */

	public void mul(Zahl z) {
		logger.trace(">> mul(Zahl)");
		Rational local = (Rational) z;
		p = p * local.p;
		q = q * local.q;
		kuerzen();
		logger.info("** Ungekürzte multiplizierte Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< mul(Zahl)");
	}

	/**
	 * Wandelt eine Integer Zahl in ein Objekt der Klasse Rational um und
	 * multipliziert diese mit dem Objekt. Anschließend wird das Ergebnis gekürzt.
	 * 
	 * \param[in] i der zu subtrahierende Integer Wert. \param local der Integer
	 * Wert als rationale Zahl.
	 */

	public void mul(int i) {
		logger.trace(">> mul(int)");
		Rational local = new Rational(i);
		mul(local);
		kuerzen();
		logger.trace("<< mul(int)");
	}

	/**
	 * Wandelt eine Objekt der Klasse Zahl in eins der Klasse Rational um und
	 * dividiert das Objekt durch diese Zahl. Anschließend wird das Ergebnis
	 * gekürzt.
	 * 
	 * \param[in] z die zu Zahl, durch die dividiert wird. \param local die zu Zahl,
	 * durch die dividiert wird, als rationale Zahl. \param p der Zähler der
	 * Division. \param q der Nenner der Division.
	 */

	public void div(Zahl z) {
		logger.trace(">> div(Zahl)");
		Rational local = (Rational) z;
		p = p * local.q;
		q = q * local.p;
		kuerzen();
		logger.info("** Ungekürzte dividierte Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< div(Zahl)");
	}

	/**
	 * Wandelt eine Integer Zahl in ein Objekt der Klasse Rational um und dividiert
	 * das Objekt durch diese Zahl. Anschließend wird das Ergebnis gekürzt.
	 * 
	 * \param[in] i der Integer Wert, durch welchen das Objekt dividiert wird.
	 * \param local der Integer Wert als rationale Zahl.
	 */

	public void div(int i) {
		logger.trace(">> div(int)");
		Rational local = new Rational(i);
		div(local);
		kuerzen();
		logger.trace("<< div(int)");
	}

	/**
	 * Der Kehrwert des Objekts wird gebildet.
	 * 
	 * \param p der neue Wert des Zählers. \param q der neue Wert des Nenners. (Der
	 * Wert darf nicht 0 sein, da nicht durch 0 dividiert werden darf.)
	 */

	public void kehrwert() {
		logger.trace(">> kehrwert()");
		int temp = p;
		p = q;
		q = temp;
		assert (q != 0);
		logger.info("** Kehrwert der Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< kehrwert()");
	}

	/**
	 * Das Vorzeichen des Nenners wird von Plus zu Minus gewechselt.
	 */

	public void switchSign() {
		logger.trace(">> switchSign()");
		p = -p;
		logger.info("** Neuer Wert Zähler {} mit umgekehrtem Vorzeichen.", p);
		logger.trace("<< switchSign()");
	}

	/**
	 * Der Bruch wird gekürzt. Falls der Wert des Nenners oder des Zählers kleiner
	 * als 0 ist, wird das Vorzeichen auf ein Plus geändert.
	 *
	 * \param teiler der größte gemeinsame Teiler wird ermittelt. \param p das
	 * Ergebnis der Division des ursprünglichen Wertes des Nenners durch den größten
	 * gemeinsamen Teilers mit dem ursprünglichen Vorzeichen. \param q das Ergebnis
	 * der Division des ursprünglichen Wertes des Zählers durch den größten
	 * gemeinsamen Teilers.
	 */

	public void kuerzen() {
		logger.trace(">> kuerzen()");
		// Vorzeichen merken und Betrag bilden
		int sign = 1;
		if (p < 0) {
			sign = -sign;
			p = -p;
		}
		if (q < 0) {
			sign = -sign;
			q = -q;
		}

		int teiler = ggt(p, q);

		// Vorzeichen restaurieren
		p = sign * p / teiler;
		q = q / teiler;
		
		logger.info("** Neuer gekürzter Wert mit dem Zähler {} und Nenner {}.", p, q);
		logger.trace("<< kuerzen()");
	}

	/**
	 * Gibt den Wert des Bruchs als Double Wert zurück.
	 */

	public double getDoubleWert() {
		return (double) p / (double) q;
	}

	/**
	 * Überprüft ob der Nenner durch den Zähler dividiert werden kann ohne Rest.
	 */

	public boolean isInteger() {
		if (p % q == 0)
			return true;
		else
			return false;
	}

	/**
	 * Berechnet den größten gemeinsamen Teiler.
	 */

	private int ggt(int x, int y) {
		while (y > 0) {
			int rest = x % y;
			x = y;
			y = rest;
		}
		return x;
	}

	/**
	 * Addiert zwei rationale Zahlen.
	 */

	public Rational add(Rational a, Rational b) {
		a.add(b);
		return a;

	}

	/**
	 * Subtrahiert zwei rationale Zahlen.
	 */

	public Rational sub(Rational a, Rational b) {

		a.sub(b);
		return a;

	}

	/**
	 * Dividiert zwei rationale Zahlen.
	 */

	public Rational div(Rational a, Rational b) {

		a.div(b);
		return a;

	}

	/**
	 * Multipliziert zwei rationale Zahlen.
	 */

	public Rational mul(Rational a, Rational b) {

		a.mul(b);
		return a;

	}

	/**
	 * Kürzt einen Bruch bei dem der Zähler und der Nenner über die Konsole
	 * eingegeben werden und gibt den gekürzten Bruch aus.
	 */

	public void eingabe() {
		logger.trace(">> eingabe()");

		Scanner sc = new Scanner(System.in);

		System.out.println("Geben Sie den Zaehler ein:");
		int i = sc.nextInt();
		p = i;

		System.out.println("Geben Sie den Nenner ein:");
		i = sc.nextInt();
		q = i;

		sc.close();

		System.out.println("Ihre Eingabe:");
		kuerzen();
		print();

		logger.info("** Ungekürzte Zahl mit dem Zähler {} und Nenner {}", p, q);
		logger.trace("<< eingabe()");
	}

}
