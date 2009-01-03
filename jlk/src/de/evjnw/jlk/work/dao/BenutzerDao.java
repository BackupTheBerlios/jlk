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

   $Id: BenutzerDao.java,v 1.1 2009/01/03 18:30:23 sgrossnw Exp $
 */
package de.evjnw.jlk.work.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.evjnw.jlk.data.Benutzer;

/**
 * Dieses Interface bildet die Schnittstelle eines Zugriffsobjekts 
 * (Data Access Object) f&uuml;r {@link Benuzter} Domain-Objekte.
 * Die Domain-Objekte werden in einem externen Speicher gehalten. 
 * <p>
 * Verwendet das DAO Pattern (Architektur 5 Struktur). 
 * @author Stephan
 */
public interface BenutzerDao {

	public void startTransaction();
	public void commitTransaction();
	public void rollbackTransaction();
	
	/**
	 * Lade den Benutzer mit der angegebenen ID
	 * @param id identifiziert den Benutzer
	 * @return das (zuvor gespeicherte) Benutzer-Objekt
	 * @throws DaoException wenn kein Benutzer zur angegebenen ID gespeichert ist 
	 */
	public Benutzer lade(int id) throws DaoException;
	
	/**
	 * Speichert das &uuml;bergebene Benutzer-Objekt.
	 * Wenn die <em>id</em> noch 0 ist, wird eine neue ID vergeben.
	 * @param b das zu speichernde Objekt, darf nicht <code>null</code> 
	 * sein
	 */
	public void speicher(Benutzer b);
	
	/**
	 * Listet die gespeicherten Benutzer-Objekte auf. 
	 */
	public List<Benutzer> liste();
}
