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

   $Id: DaoFactory.java,v 1.2 2009/04/04 18:01:53 ma08 Exp $
 */
package de.evjnw.jlk.work.dao;

/**
 * Dieses Interface bietet einen strukturierten Zugriff auf die 
 * Zugriffsobjekte (Data Access Objects). 
 * @author Stephan
 */
public interface DaoFactory {
	
	/**
	 * @return das {@link Benutzer} DAO.
	 */
	public BenutzerDao getBenutzerDao();
	/**
	 * @return das {@link Benutzer} DAO.
	 */
	public AnhangDao getAnhangDao();
}
