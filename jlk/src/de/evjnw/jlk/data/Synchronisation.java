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

   $Id: Synchronisation.java,v 1.3 2009/03/22 14:14:02 ma08 Exp $
 */
package de.evjnw.jlk.data;
/**
 * Diese Klasse stellt Informationen zur letzten Syncronisation dar.
 * Ist noch nicht vollständig.
 * @author Mario Aldag
*/
public class Synchronisation{

	private int id;
	/**
*/
private int letzterSync;
/**
*/
private String quelle;

public Synchronisation(){
	
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
 * @return the letzterSync
 */
public int getLetzterSync() {
	return letzterSync;
}

/**
 * @param letzterSync the letzterSync to set
 */
public void setLetzterSync(int letzterSync) {
	this.letzterSync = letzterSync;
}

/**
 * @return the quelle
 */
public String getQuelle() {
	return quelle;
}

/**
 * @param quelle the quelle to set
 */
public void setQuelle(String quelle) {
	this.quelle = quelle;
}

}

