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

   $Id: SucheDao.java,v 1.1 2009/03/23 19:09:23 ma08 Exp $
 */
package de.evjnw.jlk.work.dao;

import java.util.List;

import de.evjnw.jlk.data.Benutzer;
import de.evjnw.jlk.data.Suche;


/**
 * Dieses Interface bildet die Schnittstelle eines Zugriffsobjekts 
 * (Data Access Object) f&uuml;r {@link Suche} Domain-Objekte.
 * Die Domain-Objekte werden in einem externen Speicher gehalten. 
 * <p>
 * Verwendet das DAO Pattern (Architektur 5 Struktur). 
 * @author Mario
 */
public interface SucheDao {

	public void startTransaction();
	public void commitTransaction();
	public void rollbackTransaction();
	
	/**
	 * Lade die Suche mit der angegebenen ID
	 * @param id identifiziert die Suche
	 * @return das (zuvor gespeicherte)Such-Objekt
	 * @throws DaoException wenn keine Suche zur angegebenen ID gespeichert ist 
	 */
	public Suche lade(int id) throws DaoException;
	
	/**
	 * Speichert das &uuml;bergebene Such-Objekt.
	 * Wenn die <em>id</em> noch 0 ist, wird eine neue ID vergeben.
	 * @param b das zu speichernde Objekt, darf nicht <code>null</code> 
	 * sein
	 */
	public void speicher(Suche b);
	
	/**
	 * Listet die gespeicherten Such-Objekte auf. 
	 */
	public List<Suche> liste();
	
	/**
	 * Listet alle Suchen zu einem Benutzer
	 * @param b Benutzerobjekt
	 * @return eine Liste mit allen Suchobjekten
	 */
	public List<Suche> liste(Benutzer b);
}
