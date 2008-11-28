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

   $Id: Synchronisation.java,v 1.1 2008/11/28 13:25:44 ma08 Exp $
 */
package de.evjnw.jlk.data;
/**
 * @author Mario Aldag
 * Diese Klasse stellt Informationen zur letzten Syncronisation dar.
 * Ist noch nicht vollständig.
*/
public class Synchronisation{
/**
*/
private int LetzterSync;
/**
*/
private String Quelle;

public Synchronisation(){
	
}

/**
 * @return the letzterSync
 */
public int getLetzterSync() {
	return LetzterSync;
}

/**
 * @param letzterSync the letzterSync to set
 */
public void setLetzterSync(int letzterSync) {
	LetzterSync = letzterSync;
}

/**
 * @return the quelle
 */
public String getQuelle() {
	return Quelle;
}

/**
 * @param quelle the quelle to set
 */
public void setQuelle(String quelle) {
	Quelle = quelle;
}

}

