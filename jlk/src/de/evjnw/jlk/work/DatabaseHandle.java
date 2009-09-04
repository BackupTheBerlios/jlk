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

   $Id: DatabaseHandle.java,v 1.1 2009/09/04 21:05:04 sgrossnw Exp $
 */
package de.evjnw.jlk.work;

/**
 * Diese Schnittstelle bietet den Zugriff auf die gesamte Datenbank. Sie ist mit der 
 * {@link de.evjnw.jlk.work.dao.DaoFactory} verwandt aber arbeitet auf einer höheren Ebene.
 * @author Stephan Groß
 *
 */
public interface DatabaseHandle {

	/** 
	 * Schließt die Datenbank. 
	 */
	public void close();
	
}
