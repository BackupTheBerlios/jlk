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

   $Id: Suchergebnis.java,v 1.3 2009/03/22 14:14:02 ma08 Exp $
 */
package de.evjnw.jlk.data;
/**
 * Diese Klasse stellt das Suchergebnis dar und wird von der Suchmethode aufgerufen,
 * die von der Klasse Suche eine Suche erhält. 
 * 
 * @author Mario Aldag
 */
public class Suchergebnis{

	private int id;
	/**
 * Die alte Suche wird hier gespeichert.
*/
private Suche suche;

/**
 * Das Ergebnis als mehrdimensionaler String für eine tabellarische Übersicht.
*/
private String[][] ergebnis;
/**
 * Die Dauer der Suchanfrage
*/
private int dauer;

/**
 * 
 * @param Suche
 * @param Ergebnis
 */
public Suchergebnis(Suche Suche, String[][] Ergebnis){
	this.suche=Suche;
	this.ergebnis=Ergebnis;
	this.setDauer(0);
}

/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the dauer
 */
public int getDauer() {
	return dauer;
}

/**
 * @param dauer the dauer to set
 */
public void setDauer(int dauer) {
	this.dauer = dauer;
}
/**
 * @return the suche
 */
public Suche getSuche() {
	return suche;
}

/**
 * @return the ergebnis
 */
public String[][] getErgebnis() {
	return ergebnis;
}

/**
 * @param suche the suche to set
 */
public void setSuche(Suche suche) {
	this.suche = suche;
}

/**
 * @param ergebnis the ergebnis to set
 */
public void setErgebnis(String[][] ergebnis) {
	this.ergebnis = ergebnis;
}

}

