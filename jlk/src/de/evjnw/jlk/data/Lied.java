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

   $Id: Lied.java,v 1.5 2009/04/04 18:01:53 ma08 Exp $
 */
package de.evjnw.jlk.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Datenklasse kümmert sich um die Lieder. Diese wurde analog zu meiner
 * AccessDatenbank aufgebaut und enthält Listen für Anhänge, Verknüpfungen und
 * Quellen (Materialien). Sie ist somit das Kernstück der Verwaltung.
 * 
 * @author Mario Aldag
 */
public class Lied extends DataModell {

	private String titel;
	private String interpret;
	/**
	 * Das Thema des Liedes. Ist es ein Weihnachtslied, Kinderlied oder
	 * ähnliches? Dann hier hinein.
	 */
	private String thema;

	/**
	 * Diese Liste enthält die Materialien. Dies sind die Quellen aus denen das
	 * Lied kommt.
	 */
	private List<Material> material = new ArrayList<Material>();
	/**
	 * Diese Liste enthaelt Verknuepfungen zu anderen Liedern. Diese koennen
	 * ähnliche Lieder sein oder Synonime.
	 */
	private List<Verknuepfung> verknuepfung = new ArrayList<Verknuepfung>();
	
	public void addMaterial(Material mat) {
		getMaterial().add(mat);
		mat.setLied(this);
	}
	/**
	 * @return the titel
	 */
	public String getTitel() {
		return titel;
	}

	/**
	 * @param titel
	 *            the titel to set
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}

	/**
	 * @return the interpret
	 */
	public String getInterpret() {
		return interpret;
	}

	/**
	 * @param interpret
	 *            the interpret to set
	 */
	public void setInterpret(String interpret) {
		this.interpret = interpret;
	}

	/**
	 * @return the thema
	 */
	public String getThema() {
		return thema;
	}

	/**
	 * @param thema
	 *            the thema to set
	 */
	public void setThema(String thema) {
		this.thema = thema;
	}

	/**
	 * @return the material
	 */
	public List<Material> getMaterial() {
		return material;
	}

	/**
	 * @return the verknuepfung
	 */
	public List<Verknuepfung> getVerknuepfung() {
		return verknuepfung;
	}

	/**
	 * @param material
	 *            the material to set
	 */
	public void setMaterial(List<Material> material) {
		this.material = material;
	}

	/**
	 * @param verknuepfung
	 *            the verknuepfung to set
	 */
	public void setVerknuepfung(List<Verknuepfung> verknuepfung) {
		this.verknuepfung = verknuepfung;
	}

}
