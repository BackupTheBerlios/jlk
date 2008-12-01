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

   $Id: UiCommand.java,v 1.1 2008/12/01 18:50:00 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

/**
 * Diese Klasse kapselt eine vom Benutzer angesto&szlig;ene Aktion.
 * 
 * @author Stephan
 */
public class UiCommand {

	/** 
	 * was soll getan werden?
	 */
	private String verb;

	/**
	 * @param verb the verb to set
	 */
	public void setVerb(String verb) {
		this.verb = verb;
	}

	/**
	 * @return the verb
	 */
	public String getVerb() {
		return verb;
	}
}
