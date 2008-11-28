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

   $Id: DataModell.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;
import java.text.*;
/**
 * @author Mario Aldag
 * Die SuperKlasse, die Attribute zur Verfügung stellt, die alle brauchen.
*/
public class DataModell{
/**
 * Id für die Datenbank
*/
private int id;
/**
 * Versionierung
*/
private int version;
/**
*/
private int Hinzugefuegt_am;
/**
*/
private String Hinzugefuegt_durch;

/**
 * Konstruktor
 * @param durch - Person des hinzufügens
 */
public DataModell(String durch){
	//this.id=
	//this.version=
	this.setHinzugefuegt_am(DateFormat.SHORT);
	this.setHinzugefuegt_durch(durch);
	
}
public DataModell(){
	this.setHinzugefuegt_am(DateFormat.SHORT);
}
/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the version
 */
public int getVersion() {
	return version;
}

/**
 * @param version the version to set
 */
public void setVersion(int version) {
	this.version = version;
}

/**
 * @return the hinzugefuegt_am
 */
public int getHinzugefuegt_am() {
	return Hinzugefuegt_am;
}

/**
 * @param hinzugefuegt_am the hinzugefuegt_am to set
 */
public void setHinzugefuegt_am(int hinzugefuegt_am) {
	Hinzugefuegt_am = hinzugefuegt_am;
}

/**
 * @return the hinzugefuegt_durch
 */
public String getHinzugefuegt_durch() {
	return Hinzugefuegt_durch;
}

/**
 * @param hinzugefuegt_durch the hinzugefuegt_durch to set
 */
public void setHinzugefuegt_durch(String hinzugefuegt_durch) {
	Hinzugefuegt_durch = hinzugefuegt_durch;
}

}

