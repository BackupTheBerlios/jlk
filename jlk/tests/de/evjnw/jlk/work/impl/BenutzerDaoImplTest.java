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

   $Id: BenutzerDaoImplTest.java,v 1.2 2009/03/21 15:28:06 ma08 Exp $
 */
package de.evjnw.jlk.work.impl;

import de.evjnw.jlk.data.Benutzer;
import de.evjnw.jlk.work.dao.BenutzerDao;
import junit.framework.TestCase;

/**
 * @author Stephan
 *
 */
public class BenutzerDaoImplTest extends TestCase {

	/** zu testende Komponente. */
	BenutzerDao component; 
	
	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		DaoFactoryImpl factory = new DaoFactoryImpl("sa", "");
		component = factory.getBenutzerDao();
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#lade(int)}.
	 */
	public void testLade() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#liste()}.
	 */
	public void testListe() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#speicher(de.evjnw.jlk.data.Benutzer)}.
	 */
	public void testSpeicher() {
		Benutzer b = new Benutzer("Hans", "Albers");
		component.startTransaction();
		component.speicher(b);
		component.commitTransaction();
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#commitTransaction()}.
	 */
	public void testCommitTransaction() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#rollbackTransaction()}.
	 */
	public void testRollbackTransaction() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#startTransaction()}.
	 */
	public void testStartTransaction() {
		fail("Not yet implemented");
	}

}
