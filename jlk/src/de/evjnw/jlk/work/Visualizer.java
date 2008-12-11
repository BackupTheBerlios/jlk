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

   $Id: Visualizer.java,v 1.2 2008/12/11 14:49:45 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

import java.util.Set;

/**
 * Dieses Interface bietet die Darstellung von Daten und Meldungen. 
 * 
 * @author Stephan
 */
public interface Visualizer {

	/** 
	 * present a message to the user and wait for confirmation.  
	 * @param title
	 * @param message
	 */
	public void presentInformation(String title, String message, InfoType type);  
	
	/**
	 * Diese Enum bildet die verschiedenen Formen einer 
	 * Information ab. 
	 */
	public enum InfoType {
		INFORMATION, WARNING, ERROR;
	}
	
	/** 
	 * Present a message to the user and wait for his reaction.  
	 * @param title
	 * @param message
	 * @param choices the set of possible choices 
	 */
	public UserChoice askUser(String title, String message, Set<UserChoice> choices);  

	/** 
	 * Diese Enum stellt die verschiedenen M&ouml;glichkeiten einer 
	 * Benutzer-R&uuml;ckmeldung dar.   
	 */
	public enum UserChoice {
		OK, CANCEL, YES, NO;
	}
}
