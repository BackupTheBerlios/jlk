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

   $Id: Verknuepfung.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;
/**
 * Diese Klasse dient zum Speichern von Verknüpfungen zwischen Liedern.
 * Sie enthält auch eine Methode zum auffinden des anderen Liedes.
*/
public class Verknuepfung extends DataModell{
/**
 * Lied 1
*/
private Lied Lied1;
/**
 * Lied 2
*/
private Lied Lied2;
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
	this.Lied1=Lied1;
	this.Lied2=Lied2;
}

public Lied anderesLied(Lied ich) {
	if(ich.equals(Lied1)){
		return Lied2;
    }
	else if(ich.equals(Lied2)){
		return Lied1;
	}
		return null;
}
}

