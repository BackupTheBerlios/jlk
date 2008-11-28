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

   $Id: Suche.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;
import java.text.DateFormat;
/**
 * @author Mario Aldag
 * Diese Klasse wird mit den Suchdaten gefüttert um dann die Suche auszuführen.
*/
public class Suche{
/**
 * Der Suchstring, nach dem gesucht werden soll.
*/
private String Suchtext;
/**
 * Eine Sortierung?
*/
private String Reihenfolge;
/**
 * Wie viele Ergebnisse pro Seite
*/
private int ErgebnisseproSeite;
/**
 * Das aktuelle Datum der Suche
*/
private int Datum;
/**
 * Wenn die Suche gespeichert werden soll, kann der Benutzer der Suche einen Namen geben
*/
private String Titel;
/**
 * Der Benutzer, der die Suche ausführt. 
*/
private String Benutzer;

/**
 * Der Standardkonstruktor. Er fügt defaultmäßig 10 Ergebnisse pro Seite, bei "ASC" Sortierung ein.
 * Der Benutzer ist Anonymus und daher wird die Suche nicht gespeichert.
 * @param Suchtext
 */
public Suche(String Suchtext){
	this.setSuchtext(Suchtext);
	this.Datum=DateFormat.SHORT;
	
	//Defaultwerte für den Rest setzen, damit Suche ausgeführt werden kann
	this.setReihenfolge("ASC");
	this.setErgebnisseproSeite(10);
	this.setBenutzer("ANONYMUS");
}

/**
 * @return the suchtext
 */
public String getSuchtext() {
	return Suchtext;
}

/**
 * @param suchtext the suchtext to set
 */
public void setSuchtext(String suchtext) {
	Suchtext = suchtext;
}

/**
 * @return the reihenfolge
 */
public String getReihenfolge() {
	return Reihenfolge;
}

/**
 * @param reihenfolge the reihenfolge to set
 */
public void setReihenfolge(String reihenfolge) {
	Reihenfolge = reihenfolge;
}

/**
 * @return the ergebnisseproSeite
 */
public int getErgebnisseproSeite() {
	return ErgebnisseproSeite;
}

/**
 * @param ergebnisseproSeite the ergebnisseproSeite to set
 */
public void setErgebnisseproSeite(int ergebnisseproSeite) {
	ErgebnisseproSeite = ergebnisseproSeite;
}

/**
 * @return the titel
 */
public String getTitel() {
	return Titel;
}

/**
 * @param titel the titel to set
 */
public void setTitel(String titel) {
	Titel = titel;
}

/**
 * @return the benutzer
 */
public String getBenutzer() {
	return Benutzer;
}

/**
 * @param benutzer the benutzer to set
 */
public void setBenutzer(String benutzer) {
	Benutzer = benutzer;
}

/**
 * @return the datum
 */
public int getDatum() {
	return Datum;
}


}

