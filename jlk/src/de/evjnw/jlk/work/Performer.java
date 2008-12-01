/* 
   JLK - Java Lieder Katalog
   Copyright 2008, Stephan Gross

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: Performer.java,v 1.1 2008/12/01 18:50:00 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

/**
 * Dieses Interface bildet die nach au&szlig;en sichtbare Schnittstelle 
 * des "work" Packages.
 * Hier sind die Methoden gesammelt, um Aktionen oder T&auml;tigkeiten 
 * anzusto&szlig;en, sowie um den aktuellen "Zustand" der Anwendung 
 * abzufragen.   
 * @author Stephan
 */
public interface Performer {

	/**
	 * Das angegebene Kommando soll ausgef&uuml;hrt werden. 
	 * @param command 
	 * 		gibt an, was getan werden soll, 
	 * 		darf nicht <code>null</code> sein
	 */
	public void perform(UiCommand command);
	
}
