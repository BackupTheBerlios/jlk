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

   $Id: Benutzer.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;
import java.util.*;
/**
 * @author Mario Aldag
 * Diese Datenklasse beschreibt den Benutzer.
 * Der Benutzer kann hier auch seine Favoriten und Suchen speichern. 
*/
public class Benutzer{

private String Vorname;
private String Nachname;
private String Passwort;
/**
 * Letzter Login des Benutzers. Wird für die Teaser benötigt.
*/
private int LastLogin;
/**
 * Seine Liste mit Favoriten
*/
private List<Favoriten> Favoriten;
/**
 * Seine Liste mit gespeicherten Suchen.
*/
private List<Suche> Suche;

/**
 * Einen Benutzer erzeugen
 */
public Benutzer(String Vorname, String Nachname){
	this.setVorname(Vorname);
	this.setNachname(Nachname);
	
	this.setPasswort("Test");
}

/**
 * Diese Methode erzeugt ein Password
 */

/**
 * @return the vorname
 */
public String getVorname() {
	return Vorname;
}
/**
 * @param vorname the vorname to set
 */
public void setVorname(String vorname) {
	Vorname = vorname;
}
/**
 * @return the nachname
 */
public String getNachname() {
	return Nachname;
}
/**
 * @param nachname the nachname to set
 */
public void setNachname(String nachname) {
	Nachname = nachname;
}
/**
 * @return the passwort
 */
public String getPasswort() {
	return Passwort;
}
/**
 * @param passwort the passwort to set
 */
private void setPasswort(String passwort) {
	Passwort = passwort;
}
/**
 * @return the lastLogin
 */
public int getLastLogin() {
	return LastLogin;
}
/**
 * @param lastLogin the lastLogin to set
 */
public void setLastLogin(int lastLogin) {
	LastLogin = lastLogin;
}
/**
 * @return the favoriten
 */
public List<Favoriten> getFavoriten() {
	return Favoriten;
}
/**
 * @param favoriten the favoriten to set
 */
public void setFavoriten(List<Favoriten> favoriten) {
	Favoriten = favoriten;
}

/**
 * @param suche the suche to set
 */
public void setSuche(List<Suche> suche) {
	Suche = suche;
}

/**
 * @return the suche
 */
public List<Suche> getSuche() {
	return Suche;
}


}

