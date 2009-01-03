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

   $Id: DaoException.java,v 1.1 2009/01/03 18:30:23 sgrossnw Exp $
 */
package de.evjnw.jlk.work.dao;

/**
 * Diese Exception bietet eine Applikations-spezifische Kapselung 
 * der beim DAO-Zugriff auftretenden Fehler. 
 * 
 * @author Stephan
 */
public class DaoException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor f&uuml;r eine Exception in der DAO-Schicht.
	 * @param message
	 */
	public DaoException(String message) {
		super(message);
	}

	/**
	/**
	 * Constructor f&uuml;r eine Exception in der DAO-Schicht.
	 * 
	 * @param message
	 * @param throwable
	 */
	public DaoException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
