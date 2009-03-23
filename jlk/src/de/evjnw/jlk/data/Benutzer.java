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

   $Id: Benutzer.java,v 1.7 2009/03/23 19:09:23 ma08 Exp $
 */
package de.evjnw.jlk.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Diese Datenklasse beschreibt den Benutzer. Der Benutzer kann hier auch seine
 * Favoriten und Suchen speichern.
 * 
 * @author Mario Aldag
 */
public class Benutzer extends DataModell {

	private String vorname;
	private String nachname;
	private String passwort;
	/**
	 * Letzter Login des Benutzers. Wird f�r die Teaser ben�tigt.
	 */
	private Date lastLogin;
	/**
	 * Seine Liste mit Favoriten
	 */
	private List<Favoriten> favoriten = new ArrayList<Favoriten>();
	/**
	 * Seine Liste mit gespeicherten Suchen.
	 */
	private List<Suche> suche = new ArrayList<Suche>();

	/** Default Constructor */
	public Benutzer() {

	}

	/**
	 * Einen Benutzer erzeugen
	 */
	public Benutzer(String Vorname, String Nachname) {
		this.setVorname(Vorname);
		this.setNachname(Nachname);

		this.setPasswort("Test");
	}

	/**
	 * F�gt dem Benutzer ein Favorit hinzu
	 * 
	 * @param fav
	 */
	public void addFavoriten(Favoriten fav) {
		getFavoriten().add(fav);
		fav.setBenutzer(this);
	}
	
	/**
	 * F�gt dem Benutzer eine Suche hinzu
	 * @param search
	 */
	public void addSuche(Suche search) {
		getSuche().add(search);
		search.setBenutzer(this);
	}
	/**
	 * Diese Methode erzeugt ein Password
	 */

	/**
	 * @return the vorname
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @param vorname
	 *            the vorname to set
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	/**
	 * @return the nachname
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @param nachname
	 *            the nachname to set
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	/**
	 * @return the passwort
	 */
	public String getPasswort() {
		return passwort;
	}

	/**
	 * @param passwort
	 *            the passwort to set
	 */
	private void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}

	/**
	 * @param lastLogin
	 *            the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	/**
	 * @return the favoriten
	 */
	public List<Favoriten> getFavoriten() {
		return favoriten;
	}

	/**
	 * @param favoriten
	 *            the favoriten to set
	 */
	public void setFavoriten(List<Favoriten> favoriten) {
		this.favoriten = favoriten;
	}

	/**
	 * @param suche
	 *            the suche to set
	 */
	public void setSuche(List<Suche> suche) {
		this.suche = suche;
	}

	/**
	 * @return the suche
	 */
	public List<Suche> getSuche() {
		return suche;
	}

}
