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

   $Id: Material.java,v 1.5 2009/04/04 18:01:53 ma08 Exp $
 */
package de.evjnw.jlk.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse Material dient zum Bündeln von Anhängen. Jedes Lied muss
 * mindestens ein Material haben (eine Stelle aus einem Liederheft). Dieses
 * Material (z.B. Notenblatt) wird dann verwertet um eine Präsentation
 * vorzubereiten. Dies wäre dann ein Anhang.
 * 
 * @author Mario Aldag
 */
public class Material extends DataModell {

	/**
	 * Für das Hibernate Mapping. Zeigt auf das Lied, das dieses Material
	 * beinhaltet und darf auch nur von Hibernate zum schreiben genutzt werden.
	 */
	private Lied lied;

	/**
	 * Das Musikbuch aus dem das Lied kopiert worden ist.
	 */
	private String buch;
	/**
	 * Der Titel
	 */
	private int seite;
	/**
	 * Die Seite in dem Buch
	 */
	private String art;
	/**
	 * Die Tonart des Materials
	 */
	private String tonart;
	/**
	 * Der Takt des Materials
	 */
	private String takt;
	/**
	 * Die Akkorde
	 */
	private String akkorde;
	/**
	 * Jedes Material hat den Anhang. Also die umgesetzten (digitalisierten)
	 * Medien als Beispiel.
	 */
	private List<Anhang> anhang=new ArrayList<Anhang>();

	/**
	 * 
	 * @param durch
	 * @param Buch
	 * @param Seite
	 * 
	 */
	public Material(String durch, String Buch, int Seite) {
		super(durch);
		this.setBuch(Buch);
		this.setSeite(Seite);
	}

	public Material() {

	}

	public void addAnhang(Anhang ang) {
		getAnhang().add(ang);
		ang.setMaterial(this);
	}

	/**
	 * @return the buch
	 */
	public String getBuch() {
		return buch;
	}

	/**
	 * @param buch
	 *            the buch to set
	 */
	public void setBuch(String buch) {
		this.buch = buch;
	}

	/**
	 * @return the seite
	 */
	public int getSeite() {
		return seite;
	}

	/**
	 * @param seite
	 *            the seite to set
	 */
	public void setSeite(int seite) {
		this.seite = seite;
	}

	/**
	 * @return the art
	 */
	public String getArt() {
		return art;
	}

	/**
	 * @param art
	 *            the art to set
	 */
	public void setArt(String art) {
		this.art = art;
	}

	/**
	 * @return the tonart
	 */
	public String getTonart() {
		return tonart;
	}

	/**
	 * @param tonart
	 *            the tonart to set
	 */
	public void setTonart(String tonart) {
		this.tonart = tonart;
	}

	/**
	 * @return the takt
	 */
	public String getTakt() {
		return takt;
	}

	/**
	 * @param takt
	 *            the takt to set
	 */
	public void setTakt(String takt) {
		this.takt = takt;
	}

	/**
	 * @return the akkorde
	 */
	public String getAkkorde() {
		return akkorde;
	}

	/**
	 * @param akkorde
	 *            the akkorde to set
	 */
	public void setAkkorde(String akkorde) {
		this.akkorde = akkorde;
	}

	/**
	 * @return the anhang
	 */
	public List<Anhang> getAnhang() {
		return anhang;
	}

	/**
	 * @param anhang
	 *            the anhang to set
	 */
	public void setAnhang(List<Anhang> anhang) {
		this.anhang = anhang;
	}

	/**
	 * @return the lied
	 * 
	 */

	public Lied getLied() {
		return lied;
	}

	/**
	 * @param lied
	 *            the lied to set
	 * 
	 */
	public void setLied(Lied lied) {
		this.lied = lied;
	}

}
