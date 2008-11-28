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

   $Id: Favoriten.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;


/**
 * @author Mario Aldag
 * Diese Datenklasse kümmert sich um die Favoriten. Diese erbt nicht von dem DataModell
*/
public class Favoriten extends DataModell{
/**
 * Das Lied, das er in seinen Favoriten haben möchte.
*/
private Lied Lied;
/**
 * Seine Bewertung. Dadurch kann der Benutzer Favoriten sortieren.
*/
private int Bewertung;
/**
 * Einen Kommentar vielleicht?
*/
private String Kommentar;

public Favoriten(Lied Lied){
	super();
	this.setLied(Lied);
	}
/**
 * @return the lied
 */
public Lied getLied() {
	return Lied;
}
/**
 * @param lied the lied to set
 */
public void setLied(Lied lied) {
	Lied = lied;
}
/**
 * @return the bewertung
 */
public int getBewertung() {
	return Bewertung;
}
/**
 * @param bewertung the bewertung to set
 */
public void setBewertung(int bewertung) {
	Bewertung = bewertung;
}
/**
 * @return the kommentar
 */
public String getKommentar() {
	return Kommentar;
}
/**
 * @param kommentar the kommentar to set
 */
public void setKommentar(String kommentar) {
	Kommentar = kommentar;
}



}

