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

   $Id: Zusammenstellung.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */

package de.evjnw.jlk.data;
import java.util.*;
/**
 * @author Mario Aldag
 * Diese Klasse beinhaltet Zusammenstellungen. Für Liederhefte oder Songs bei Beatbox oder ähnlichem.
*/
public class Zusammenstellung extends DataModell{
/**
 * Der Titel
*/
private String Titel;
/**
 * Eine Beschreibung der Liste
*/
private String Beschreibung;
/**
 * Eine Liste mit allen zu der Zusammenstellung gehörenden Liedern
*/
private List<Lied> Lieder;
/**
 * Wenn direkte Anhänge zu einer Zusammenstellung vorhanden sind, dann kann man diese hier eintragen.
*/
private List<Anhang> Anhang;

public Zusammenstellung(String durch, String Titel, List<Lied> Lieder){
	super(durch);
	this.setTitel(Titel);
	this.setLieder(Lieder);
	
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
 * @return the beschreibung
 */
public String getBeschreibung() {
	return Beschreibung;
}

/**
 * @param beschreibung the beschreibung to set
 */
public void setBeschreibung(String beschreibung) {
	Beschreibung = beschreibung;
}

/**
 * @return the lieder
 */
public List<Lied> getLieder() {
	return Lieder;
}

/**
 * @param lieder the lieder to set
 */
public void setLieder(List<Lied> lieder) {
	Lieder = lieder;
}

/**
 * @return the anhang
 */
public List<Anhang> getAnhang() {
	return Anhang;
}

/**
 * @param anhang the anhang to set
 */
public void setAnhang(List<Anhang> anhang) {
	Anhang = anhang;
}

}

