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

   $Id: DataModell.java,v 1.4 2008/12/15 22:15:51 ma08 Exp $
 */
package de.evjnw.jlk.data;
import java.util.Date;
/**
 * Die SuperKlasse, die Attribute zur Verfügung stellt, die alle brauchen.
 * @author Mario Aldag
*/
public abstract class DataModell{
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
private Date hinzugefuegtAm;
/**
*/
private String hinzugefuegtDurch;
private Date geaendertAm;
/**
 * Konstruktor
 * @param durch - Person des hinzufügens
 */
public DataModell(String durch){

	Date jetzt = new Date();
	
	this.setHinzugefuegtAm(jetzt);
	this.setHinzugefuegtDurch(durch);
	
}
public DataModell(){
	
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
public Date getHinzugefuegtAm() {
	return hinzugefuegtAm;
}

/**
 * @param hinzugefuegt_am the hinzugefuegt_am to set
 */
public void setHinzugefuegtAm(Date hinzugefuegt_am) {
	hinzugefuegtAm = hinzugefuegt_am;
}

/**
 * @return the hinzugefuegt_durch
 */
public String getHinzugefuegtDurch() {
	return hinzugefuegtDurch;
}

/**
 * @param hinzugefuegt_durch the hinzugefuegt_durch to set
 */
public void setHinzugefuegtDurch(String hinzugefuegt_durch) {
	hinzugefuegtDurch = hinzugefuegt_durch;
}
/**
 * @return the geaendertAm
 */
public Date getGeaendertAm() {
	return geaendertAm;
}
/**
 * @param geaendertAm the geaendertAm to set
 */
public void setGeaendertAm(Date geaendertAm) {
	this.geaendertAm = geaendertAm;
}

}

