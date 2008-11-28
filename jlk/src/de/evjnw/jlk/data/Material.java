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

   $Id: Material.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;
import java.util.*;
/**
*/
public class Material extends DataModell{
/**
 * Das Musikbuch aus dem das Lied kopiert worden ist.
*/
private String Buch;
/**
 * Der Titel
*/
private int Seite;
/**
 * Die Seite in dem Buch
*/
private String Art;
/**
 * Die Tonart des Materials
*/
private String Tonart;
/**
 * Der Takt des Materials
*/
private String Takt;
/**
 * Die Akkorde
*/
private String Akkorde;
/**
 * Jedes Material hat den Anhang. Also die umgesetzten (digitalisierten) Medien als Beispiel.
 */
private List<Anhang> Anhang;

/**
 * 
 * @param durch
 * @param Buch
 * @param Seite
 * 
 */
public Material(String durch,String Buch, int Seite){
	super(durch);
	this.setBuch(Buch);
	this.setSeite(Seite);
}

/**
 * @return the buch
 */
public String getBuch() {
	return Buch;
}

/**
 * @param buch the buch to set
 */
public void setBuch(String buch) {
	Buch = buch;
}

/**
 * @return the seite
 */
public int getSeite() {
	return Seite;
}

/**
 * @param seite the seite to set
 */
public void setSeite(int seite) {
	Seite = seite;
}

/**
 * @return the art
 */
public String getArt() {
	return Art;
}

/**
 * @param art the art to set
 */
public void setArt(String art) {
	Art = art;
}

/**
 * @return the tonart
 */
public String getTonart() {
	return Tonart;
}

/**
 * @param tonart the tonart to set
 */
public void setTonart(String tonart) {
	Tonart = tonart;
}

/**
 * @return the takt
 */
public String getTakt() {
	return Takt;
}

/**
 * @param takt the takt to set
 */
public void setTakt(String takt) {
	Takt = takt;
}

/**
 * @return the akkorde
 */
public String getAkkorde() {
	return Akkorde;
}

/**
 * @param akkorde the akkorde to set
 */
public void setAkkorde(String akkorde) {
	Akkorde = akkorde;
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

