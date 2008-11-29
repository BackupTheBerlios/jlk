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

   $Id: Verknuepfung.java,v 1.2 2008/11/29 23:58:17 sgrossnw Exp $
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
 * Lied 2
*/
private Lied lied2;
/**
 * @param ich 
 * @param Return 
 * @return 
*/

/**
 * @param Lied1 - das eine Lied
 * @param Lied2 - und das andere zu verknüpfende Lied
 * @param durch - Der Benutzer
 */
public Verknuepfung(Lied Lied1,Lied Lied2,String durch){
	super(durch);
	this.lied1=Lied1;
	this.lied2=Lied2;
}

public Lied anderesLied(Lied ich) {
	if(ich.equals(lied1)){
		return lied2;
    }
	else if(ich.equals(lied2)){
		return lied1;
	}
		return null;
}
}

