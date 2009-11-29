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

   $Id: Zusammenstellung.java,v 1.6 2009/11/29 14:01:01 ma08 Exp $
 */

package de.evjnw.jlk.data;
import java.util.ArrayList;
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
private List<Lied> lieder= new ArrayList<Lied>();
/**
 * Wenn direkte Anhänge zu einer Zusammenstellung vorhanden sind, dann kann man diese hier eintragen.
*/
private List<Anhang> anhang= new ArrayList<Anhang>();

	/** Default Constructor. */
	public Zusammenstellung() {
	}


public Zusammenstellung(String durch, String titel, List<Lied> lieder){
	super(durch);
	this.setTitel(titel);
	this.setLieder(lieder);
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
public void addAnhang(Anhang anhang) {
	getAnhang().add(anhang);
}
}

