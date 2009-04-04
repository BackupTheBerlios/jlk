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

   $Id: SucheDaoImplTest.java,v 1.1 2009/04/04 18:01:53 ma08 Exp $
 */
package de.evjnw.jlk.work.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.evjnw.jlk.data.Suche;

import de.evjnw.jlk.work.dao.SucheDao;
import junit.framework.TestCase;

/**
 * @author Mario
 * 
 */
public class SucheDaoImplTest extends TestCase {

	private static final Logger log = Logger.getLogger(SucheDaoImplTest.class);

	/** zu testende Komponente. */
	private SucheDao component;
	SessionFactory sf;

	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		DaoFactoryImpl factory = new DaoFactoryImpl("sa", "");
		component = factory.getSucheDao();
		sf = factory.factory;
	}

	protected void tearDown() {
		Session sess = sf.getCurrentSession();
		Transaction t = sess.beginTransaction();
		sess.createSQLQuery("SHUTDOWN").executeUpdate();
		t.commit();
		// sess.close();
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#lade(int)}.
	 */
	public void testLade() {
		// TODO: in den Testdaten muss sichergestellt sein, dass es einen
		// Benutzer mit dieser ID gibt
		int BENUTZER_ID = 1;

		component.startTransaction();
		Suche s = component.lade(BENUTZER_ID);
		component.commitTransaction();
		assertNotNull(s);
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#liste()}.
	 */
	@SuppressWarnings("unchecked")
	public void testListe() {

		component.startTransaction();
		List s = component.liste();
		component.commitTransaction();
		assertTrue("die Liste ist nicht leer", s.size() > 0);
		
	}

	/**
	 * Test method for
	 * {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#speicher(de.evjnw.jlk.data.Benutzer)}
	 * .
	 */
	public void testSpeicher() {
		Suche s = new Suche("From Benutzer");
		component.startTransaction();
		component.speicher(s);
		component.commitTransaction();
	}

}
