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

   $Id: Anhang.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;
/**
 * @author Mario Aldag
 * Diese Datenklasse beschreibt die Dateianhänge und speichert den Link zu der Datei
*/
public class Anhang extends DataModell{

	/**
	 * Der Titel des Anhangs. 
	*/
	private String Titel;
	
	/**
	 * Eine Kurzbeschreibung. Diese kann vom Benutzer auch zum kommentieren genutzt werden. 
	*/
	private String Beschreibung;
	/**
	 * Der Link zu der Datei. 
	*/
	private String Link;
	/**
	 * Die Sprache des Liedgutes. (Deutsch, Englisch,...)
	*/
	private String Textsprache;
	/**
	 * Der Aufbau des Gesangs (einstimmig, mehrstimmig).
	*/
	private String Gesang;
	/**
	 * Was für Akkorde sind verfügbar? (Tabulatoren, Akkorddiagramme,...)
	*/
	private String Akkordart;
	/**
	 * Was für einen Notensatz haben wir? (Partitur, Klavierauszug, ...)
	*/
	private String Notensatz;
	
	/**
	 * 
	 * @param Titel
	 * @param Beschreibung
	 * @param Link
	 * @param Textsprache
	 * @param Gesang
	 * @param Akkordart
	 * @param Notensatz
	 * @param durch
	 */
	public Anhang(String Titel, String Beschreibung, String Link, 
				  String Textsprache, String Gesang, String Akkordart, String Notensatz,String durch){
		super(durch);
		this.setTitel(Titel);
		this.setBeschreibung(Beschreibung);
		this.setLink(Link);
		this.setTextsprache(Textsprache);
		this.setGesang(Gesang);
		this.setAkkordart(Akkordart);
		this.setNotensatz(Notensatz);
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
	 * @return the link
	 */
	public String getLink() {
		return Link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		Link = link;
	}
	/**
	 * @return the textsprache
	 */
	public String getTextsprache() {
		return Textsprache;
	}
	/**
	 * @param textsprache the textsprache to set
	 */
	public void setTextsprache(String textsprache) {
		Textsprache = textsprache;
	}
	/**
	 * @return the gesang
	 */
	public String getGesang() {
		return Gesang;
	}
	/**
	 * @param gesang the gesang to set
	 */
	public void setGesang(String gesang) {
		Gesang = gesang;
	}
	/**
	 * @return the akkordart
	 */
	public String getAkkordart() {
		return Akkordart;
	}
	/**
	 * @param akkordart the akkordart to set
	 */
	public void setAkkordart(String akkordart) {
		Akkordart = akkordart;
	}
	/**
	 * @return the notensatz
	 */
	public String getNotensatz() {
		return Notensatz;
	}
	/**
	 * @param notensatz the notensatz to set
	 */
	public void setNotensatz(String notensatz) {
		Notensatz = notensatz;
	}
	
}

