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

   $Id: QuitAction.java,v 1.2 2009/09/05 10:31:38 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

import org.apache.log4j.Logger;

import de.evjnw.jlk.work.dao.DaoException;

/**
 * Diese Aktion bündelt die Aufräum-Aktivitäten am Ende der Anwendung.
 * @author Stephan Groß
 *
 */
public class QuitAction implements Performer {

	private static Logger log = Logger.getLogger(QuitAction.class);

	/** bietet die Kontrolle über die Datenbank. */
	private DatabaseHandle handle;
	
	/**
	 * {@inheritDoc}
	 */
	public void perform(UiCommand command) {
		try {
			handle.close();
		} catch (DaoException e) {
			log.error(e.getMessage(), e);
		}
	}

	/**
	 * @param handle bietet den Zugriff auf die Datenbank.
	 */
	public void setHandle(DatabaseHandle handle) {
		this.handle = handle;
	}
}
