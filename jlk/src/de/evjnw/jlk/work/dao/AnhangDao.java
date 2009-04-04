/* 
   JLK - Java Lieder Katalog
   Copyright 2008-2009, Mario Aldag

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: AnhangDao.java,v 1.1 2009/04/04 18:01:53 ma08 Exp $
 */
package de.evjnw.jlk.work.dao;

import java.util.List;

import de.evjnw.jlk.data.Anhang;

/**
 * Dieses Interface bildet die Schnittstelle eines Zugriffsobjekts 
 * (Data Access Object) f&uuml;r {@link Anhang} Domain-Objekte.
 * Die Domain-Objekte werden in einem externen Speicher gehalten. 
 * <p>
 * Verwendet das DAO Pattern (Architektur 5 Struktur). 
 * @author Mario
 */
public interface AnhangDao {

	public void startTransaction();
	public void commitTransaction();
	public void rollbackTransaction();
	
	/**
	 * Lade den Anhang mit der angegebenen ID
	 * @param id identifiziert den Benutzer
	 * @return das (zuvor gespeicherte) Benutzer-Objekt
	 * @throws DaoException wenn kein Benutzer zur angegebenen ID gespeichert ist 
	 */
	public Anhang lade(int id) throws DaoException;
	
	/**
	 * Speichert das &uuml;bergebene Anhangs-Objekt.
	 * Wenn die <em>id</em> noch 0 ist, wird eine neue ID vergeben.
	 * @param b das zu speichernde Objekt, darf nicht <code>null</code> 
	 * sein
	 */
	public void speicher(Anhang b);
	
	/**
	 * Listet die gespeicherten Benutzer-Objekte auf. 
	 */
	public List<Anhang> liste();
}
