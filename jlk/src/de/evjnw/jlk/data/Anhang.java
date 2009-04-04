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

   $Id: Anhang.java,v 1.4 2009/04/04 18:01:53 ma08 Exp $
 */
package de.evjnw.jlk.data;
/**
 * Diese Datenklasse beschreibt die Dateianhänge und speichert den Link zu der Datei
 * @author Mario Aldag
 */
public class Anhang extends DataModell{

	/**
	 * Das Material, in dem dieser Anhang verwendet wird.
	 * Für Hibernate benötigt und darf auch nur von Hibernate zum schreiben genutzt werden. 
	 */
	private Material material;
	
	/**
	 * Die Zusammenstellung, in dem dieser Anhang verwendet wird.
	 * Für Hibernate benötigt und darf auch nur von Hibernate zum schreiben genutzt werden.
	 */
	private Zusammenstellung zusammenstellung;
	
	/**
	 * Der Titel des Anhangs. 
	*/
	private String titel;
	/**
	 * Eine Kurzbeschreibung. Diese kann vom Benutzer auch zum kommentieren genutzt werden. 
	*/
	private String beschreibung;
	/**
	 * Der Link zu der Datei. 
	*/
	private String link;
	/**
	 * Die Sprache des Liedgutes. (Deutsch, Englisch,...)
	*/
	private String textsprache;
	/**
	 * Der Aufbau des Gesangs (einstimmig, mehrstimmig).
	*/
	private String gesang;
	/**
	 * Was für Akkorde sind verfügbar? (Tabulatoren, Akkorddiagramme,...)
	*/
	private String akkordart;
	/**
	 * Was für einen Notensatz haben wir? (Partitur, Klavierauszug, ...)
	*/
	private String notensatz;
	
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
	public Anhang(){}
	
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
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the textsprache
	 */
	public String getTextsprache() {
		return textsprache;
	}
	/**
	 * @param textsprache the textsprache to set
	 */
	public void setTextsprache(String textsprache) {
		this.textsprache = textsprache;
	}
	/**
	 * @return the gesang
	 */
	public String getGesang() {
		return gesang;
	}
	/**
	 * @param gesang the gesang to set
	 */
	public void setGesang(String gesang) {
		this.gesang = gesang;
	}
	/**
	 * @return the akkordart
	 */
	public String getAkkordart() {
		return akkordart;
	}
	/**
	 * @param akkordart the akkordart to set
	 */
	public void setAkkordart(String akkordart) {
		this.akkordart = akkordart;
	}
	/**
	 * @return the notensatz
	 */
	public String getNotensatz() {
		return notensatz;
	}
	/**
	 * @param notensatz the notensatz to set
	 */
	public void setNotensatz(String notensatz) {
		this.notensatz = notensatz;
	}

	/**
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}

	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}

	/**
	 * @return the zusammenstelllung
	 */
	public Zusammenstellung getZusammenstellung() {
		return zusammenstellung;
	}

	/**
	 * @param zusammenstelllung the zusammenstelllung to set
	 */
	public void setZusammenstellung(Zusammenstellung zusammenstellung) {
		this.zusammenstellung = zusammenstellung;
	}
	
}

