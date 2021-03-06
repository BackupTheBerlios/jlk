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

   $Id: QuitAction.java,v 1.3 2009/10/06 20:25:19 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

import de.evjnw.jlk.work.dao.DaoException;

/**
 * Diese Aktion b�ndelt die Aufr�um-Aktivit�ten am Ende der Anwendung.
 * @author Stephan Gro�
 */
public class QuitAction implements Performer {

	/** bietet die Kontrolle �ber die Datenbank. */
	private DatabaseHandle handle;
	
	/**
	 * {@inheritDoc}
	 */
	public void perform(UiCommand command) throws DaoException {
		DaoException caught = null;
		try {
			handle.close();
		} catch (DaoException de) {
			caught = de;
		}
		// TODO: weitere Aufr�um-Aktionen
		if (caught != null) {
			// der Aufrufer (Controller) zeigt die Fehlermeldung an
			throw caught;
		}
	}

	/**
	 * @param handle bietet den Zugriff auf die Datenbank.
	 */
	public void setHandle(DatabaseHandle handle) {
		this.handle = handle;
	}
}
