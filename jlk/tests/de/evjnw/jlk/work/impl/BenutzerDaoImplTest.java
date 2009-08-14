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

   $Id: BenutzerDaoImplTest.java,v 1.7 2009/08/14 20:52:15 sgrossnw Exp $
 */
package de.evjnw.jlk.work.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.evjnw.jlk.data.Benutzer;
import de.evjnw.jlk.data.Favoriten;
import de.evjnw.jlk.work.dao.BenutzerDao;
import junit.framework.TestCase;

/**
 * @author Stephan
 *
 */
public class BenutzerDaoImplTest extends TestCase {

	private static final Logger log = Logger.getLogger(BenutzerDaoImplTest.class);
	
	/** zu testende Komponente. */
	private BenutzerDao component; 
	SessionFactory sf;
	
	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		DaoFactoryImpl factory = new DaoFactoryImpl("sa", "");
		component = factory.getBenutzerDao();
		sf = factory.factory;
	}
	
	protected void tearDown() {
		Session sess = sf.getCurrentSession();
		Transaction t = sess.beginTransaction();
		sess.createSQLQuery("SHUTDOWN").executeUpdate();
		t.commit();
//		sess.close();
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#lade(int)}.
	 */
	public void testLade() {
		// TODO: in den Testdaten muss sichergestellt sein, dass es einen Benutzer mit dieser ID gibt
		int BENUTZER_ID = 1;
		
		component.startTransaction();
		Benutzer b = component.lade(BENUTZER_ID);
		component.commitTransaction();
		assertNotNull(b);
	}

	/**
	 * Test method for {@link de.evjnw.jlk.work.impl.BenutzerDaoImpl#liste()}.
	 */
	public void testListe() {
		// erstmal einen Benutzer hinzufügen
		testSpeicher();
		// TODO: wir könnten auch festgelegte Testdaten haben und die verabredete Größe abfragen
		
		component.startTransaction();
		List<Benutzer> bl = component.liste();
		component.commitTransaction();
		assertTrue("die Liste ist nicht leer", bl.size() > 0);
		for (Benutzer b : bl) {
			log.info("Benutzer "+b.getId()+": "+b.getVorname()+" "+b.getNachname());
			for(Favoriten fav :b.getFavoriten()){
				log.info("Favorit "+fav.getId()+": "+fav.getBewertung());
			}
		}
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

	public void testSpeicherMitFavoriten() {
		Benutzer b = new Benutzer("Birte", "Buhmann");
		Favoriten fav = new Favoriten();
		Favoriten fav2 = new Favoriten();
		Favoriten fav3 = new Favoriten();
		Favoriten fav4 = new Favoriten();
		Favoriten fav5 = new Favoriten();
		Favoriten fav6 = new Favoriten();
		fav.setBewertung(23);
		fav2.setBewertung(20);
		fav3.setBewertung(2);
		fav4.setBewertung(10);
		fav5.setBewertung(40);
		fav6.setBewertung(-40);
		
		// diese Favoriten werden nicht gespeichert
		fav.setBenutzer(b);
		fav2.setBenutzer(b);
		fav3.setBenutzer(b);
		fav4.setBenutzer(b);

		// dieser Aufruf speichert den Favoriten zusammen mit dem Benutzer
		b.addFavoriten(fav5);
		b.addFavoriten(fav6);
		component.startTransaction();
		component.speicher(b);

		component.commitTransaction();
	}
	
	
}
