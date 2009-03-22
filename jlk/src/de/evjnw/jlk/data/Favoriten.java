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

   $Id: Favoriten.java,v 1.4 2009/03/22 15:24:37 ma08 Exp $
 */
package de.evjnw.jlk.data;


/**
 * Diese Datenklasse kümmert sich um die Favoriten. Diese erbt nicht von dem DataModell
 * @author Mario Aldag
*/
public class Favoriten extends DataModell{
/**
 * Das Lied, das er in seinen Favoriten haben möchte.
*/
private Lied lied;
/**
 * Seine Bewertung. Dadurch kann der Benutzer Favoriten sortieren.
*/
private int bewertung;
/**
 * Einen Kommentar vielleicht?
*/
private String kommentar;

private Benutzer benutzer;

public Favoriten(Lied Lied){
	super();
	this.setLied(Lied);
	}

public Favoriten(){
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
 * @return the lied
 */
public Lied getLied() {
	return lied;
}
/**
 * @param lied the lied to set
 */
public void setLied(Lied lied) {
	this.lied = lied;
}
/**
 * @return the bewertung
 */
public int getBewertung() {
	return bewertung;
}
/**
 * @param bewertung the bewertung to set
 */
public void setBewertung(int bewertung) {
	this.bewertung = bewertung;
}
/**
 * @return the kommentar
 */
public String getKommentar() {
	return kommentar;
}
/**
 * @param kommentar the kommentar to set
 */
public void setKommentar(String kommentar) {
	this.kommentar = kommentar;
}



}

