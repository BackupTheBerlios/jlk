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

   $Id: Suchergebnis.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;
/**
 * @author Mario Aldag
 * Diese Klasse stellt das Suchergebnis dar und wird von der Suchmethode aufgerufen,
 * die von der Klasse Suche eine Suche erhält. 
 * 
*/
public class Suchergebnis{
/**
 * Die alte Suche wird hier gespeichert.
*/
private Suche Suche;

/**
 * Das Ergebnis als mehrdimensionaler String für eine tabellarische Übersicht.
*/
private String[][] Ergebnis;
/**
 * Die Dauer der Suchanfrage
*/
private int Dauer;

/**
 * 
 * @param Suche
 * @param Ergebnis
 */
public Suchergebnis(Suche Suche, String[][] Ergebnis){
	this.Suche=Suche;
	this.Ergebnis=Ergebnis;
	this.setDauer(0);
}

/**
 * @return the dauer
 */
public int getDauer() {
	return Dauer;
}

/**
 * @param dauer the dauer to set
 */
public void setDauer(int dauer) {
	Dauer = dauer;
}
/**
 * @return the suche
 */
public Suche getSuche() {
	return Suche;
}

/**
 * @return the ergebnis
 */
public String[][] getErgebnis() {
	return Ergebnis;
}

/**
 * @param suche the suche to set
 */
public void setSuche(Suche suche) {
	Suche = suche;
}

/**
 * @param ergebnis the ergebnis to set
 */
public void setErgebnis(String[][] ergebnis) {
	Ergebnis = ergebnis;
}

}

