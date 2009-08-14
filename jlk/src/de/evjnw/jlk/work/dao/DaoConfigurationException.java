/* 
   JLK - Java Lieder Katalog
   Copyright 2009, Stephan Gross

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: DaoConfigurationException.java,v 1.1 2009/08/14 20:26:15 sgrossnw Exp $
 */

package de.evjnw.jlk.work.dao;

/**
 * Diese Exception wird geworfen, wenn bei der Konfiguration der Datenzugriffsschicht (DAO) Fehler auftreten.
 * @author Stephan Groß
 */
public class DaoConfigurationException extends RuntimeException {

	/**
	 * Dieser Ctor ist wenig hilfreich.
	 * @deprecated
	 */
	public DaoConfigurationException() {
	}

	/**
	 * Constructor mit Fehlermeldung.
	 * @param message Fehlermeldung 
	 */
	public DaoConfigurationException(String message) {
		super(message);
	}

	/**
	 * Constructor, der eine andere Exception kapselt.
	 * Die Message der gekapselten Exception wird als eigene Message übernommen.
	 * @param wrapped die gekapselte Exception
	 */
	public DaoConfigurationException(Throwable wrapped) {
		super(wrapped.getMessage(), wrapped);
	}

	/**
	 * Constructor, der eine andere Exception kapselt
	 * @param message eine eigene Fehlermeldung
	 * @param wrapped die gekapselte Exception
	 */
	public DaoConfigurationException(String message, Throwable wrapped) {
		super(message, wrapped);
	}

}
