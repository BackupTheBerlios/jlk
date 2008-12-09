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

   $Id: Zusammenstellung.java,v 1.3 2008/12/09 09:26:11 ma08 Exp $
 */

package de.evjnw.jlk.data;
import java.util.List;
/**
 * Diese Klasse beinhaltet Zusammenstellungen. Für Liederhefte oder Songs bei Beatbox oder ähnlichem.
 * @author Mario Aldag
*/
public class Zusammenstellung extends DataModell{
/**
 * Der Titel
*/
private String titel;
/**
 * Eine Beschreibung der Liste
*/
private String beschreibung;
/**
 * Eine Liste mit allen zu der Zusammenstellung gehörenden Liedern
*/
private List<Lied> lieder;
/**
 * Wenn direkte Anhänge zu einer Zusammenstellung vorhanden sind, dann kann man diese hier eintragen.
*/
private List<Anhang> anhang;

public Zusammenstellung(String durch, String Titel, List<Lied> Lieder){
	super(durch);
	this.setTitel(Titel);
	this.setLieder(Lieder);
	
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
 * @return the beschreibung
 */
public String getBeschreibung() {
	return beschreibung;
}

/**
 * @param beschreibung the beschreibung to set
 */
public void setBeschreibung(String beschreibung) {
	this.beschreibung = beschreibung;
}

/**
 * @return the lieder
 */
public List<Lied> getLieder() {
	return lieder;
}

/**
 * @param lieder the lieder to set
 */
public void setLieder(List<Lied> lieder) {
	this.lieder = lieder;
}

/**
 * @return the anhang
 */
public List<Anhang> getAnhang() {
	return anhang;
}

/**
 * @param anhang the anhang to set
 */
public void setAnhang(List<Anhang> anhang) {
	this.anhang = anhang;
}

}

