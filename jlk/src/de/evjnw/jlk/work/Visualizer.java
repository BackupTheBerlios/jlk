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

   $Id: Visualizer.java,v 1.4 2009/10/06 20:23:38 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

import java.util.List;
import java.util.Set;

import de.evjnw.jlk.data.DataModell;

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
	 * Typical choices are: {OK}, {Yes,No}, {OK,Cancel}, {Yes,No,Cancel}.
	 * @param title
	 * @param message
	 * @param choices the set of possible choices, must not be empty 
	 * @return the selected choice out of the given set
	 */
	public UserChoice askUser(String title, String message, Set<UserChoice> choices);  

	/** 
	 * Diese Enum stellt die verschiedenen M&ouml;glichkeiten einer 
	 * Benutzer-R&uuml;ckmeldung dar.   
	 */
	public enum UserChoice {
		OK, CANCEL, YES, NO;
	}
	
	/**
	 * Startet die Darstellung eines neuen Views.
	 * @param view der Name des neuen Views
	 * @param models die anzuzeigenden Datenmodelle
	 * @param data zusätzlich anzuzeigende Daten, die nicht als Datenmodell vorliegen
	 */
	public void display(String view, List<DataModell> models, List<Object> data);
}
