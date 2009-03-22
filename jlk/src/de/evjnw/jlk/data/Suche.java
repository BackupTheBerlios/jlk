/* 
   JLK - Java Lieder Katalog
   Copyright 2008, Mario Aldag

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: Suche.java,v 1.5 2009/03/22 11:49:59 ma08 Exp $
 */
package de.evjnw.jlk.data;
import java.util.Date;
/**
 * Diese Klasse wird mit den Suchdaten gefüttert um dann die Suche auszuführen.
 * @author Mario Aldag
*/
public class Suche{
	/**
	 * Id für die Datenbank.
	 */
	private int id;

/**
 * Der Suchstring, nach dem gesucht werden soll.
*/
private String suchtext;
/**
 * Eine Sortierung?
*/
private String reihenfolge;
/**
 * Wie viele Ergebnisse pro Seite
*/
private int ergebnisseProSeite;
/**
 * Das aktuelle Datum der Suche
*/
private Date datum;
/**
 * Wenn die Suche gespeichert werden soll, kann der Benutzer der Suche einen Namen geben
*/
private String titel;
/**
 * Der Benutzer, der die Suche ausführt. 
*/
private Benutzer benutzer;

/**
 * Der Standardkonstruktor. Er fügt defaultmäßig 10 Ergebnisse pro Seite, bei "ASC" Sortierung ein.
 * Der Benutzer ist Anonymus und daher wird die Suche nicht gespeichert.
 * @param Suchtext
 */
public Suche(String Suchtext){
	this.setSuchtext(Suchtext);
	//this.datum=DateFormat.SHORT;
	
	//Defaultwerte für den Rest setzen, damit Suche ausgeführt werden kann
	this.setReihenfolge("ASC");
	this.setErgebnisseProSeite(10);
	//this.setBenutzer("ANONYMUS");
}

/**
 * @return the suchtext
 */
public String getSuchtext() {
	return suchtext;
}

/**
 * @param suchtext the suchtext to set
 */
public void setSuchtext(String suchtext) {
	this.suchtext = suchtext;
}

/**
 * @return the reihenfolge
 */
public String getReihenfolge() {
	return reihenfolge;
}

/**
 * @param reihenfolge the reihenfolge to set
 */
public void setReihenfolge(String reihenfolge) {
	this.reihenfolge = reihenfolge;
}

/**
 * @return the ergebnisseproSeite
 */
public int getErgebnisseProSeite() {
	return ergebnisseProSeite;
}

/**
 * @param ergebnisseproSeite the ergebnisseproSeite to set
 */
public void setErgebnisseProSeite(int ergebnisseproSeite) {
	ergebnisseProSeite = ergebnisseproSeite;
}

/**
 * @return the titel
 */
public String getTitel() {
	return titel;
}

/**
 * @param titel the titel to set
 */
public void setTitel(String titel) {
	this.titel = titel;
}

/**
 * @return the benutzer
 */
public Benutzer getBenutzer() {
	return benutzer;
}

/**
 * @param benutzer the benutzer to set
 */
public void setBenutzer(Benutzer benutzer) {
	this.benutzer = benutzer;
}

/**
 * @return the datum
 */
public Date getDatum() {
	return datum;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the id
 */
public int getId() {
	return id;
}

}

