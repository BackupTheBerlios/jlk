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

   $Id: Verknuepfung.java,v 1.4 2009/09/04 21:18:15 sgrossnw Exp $
 */
package de.evjnw.jlk.data;
/**
 * Diese Klasse dient zum Speichern von Verknüpfungen zwischen Liedern.
 * Sie enthält auch eine Methode zum auffinden des anderen Liedes.
 * @author Mario Aldag
*/
public class Verknuepfung extends DataModell{
/**
 * Lied 1
*/
private Lied lied1;
/**
 * @return the lied1
 */
public Lied getLied1() {
	return lied1;
}

/**
 * @param lied1 the lied1 to set
 */
public void setLied1(Lied lied1) {
	this.lied1 = lied1;
}

/**
 * @return the lied2
 */
public Lied getLied2() {
	return lied2;
}

/**
 * @param lied2 the lied2 to set
 */
public void setLied2(Lied lied2) {
	this.lied2 = lied2;
}

/**
 * Lied 2
 */
private Lied lied2;

	/** Default Constructor. */
	public Verknuepfung() {
	}

/**
 * @param lied1 - das eine Lied
 * @param lied2 - und das andere zu verknüpfende Lied
 * @param durch - Der Benutzer
 */
public Verknuepfung(Lied lied1, Lied lied2, String durch) {
	super(durch);
	this.lied1=lied1;
	this.lied2=lied2;
}
/**
 * Ausgehend von einem {@link Lied} (ich) wird über die {@link Verknuepfung} zu dem anderen, 
 * verknüpften Lied navigiert.
 * @param ich eines der verknüpften Lieder
 * @return das andere Lied aus dieser Verknüpfung, <code>null</code> wenn <em>ich</em> 
 *   nicht Bestandteil der Verknüpfung ist
 */
public Lied anderesLied(Lied ich) {
	if (ich.equals(lied1)){
		return lied2;
    }
	else if (ich.equals(lied2)){
		return lied1;
	}
	return null;
}
}
