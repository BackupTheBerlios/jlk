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

   $Id: BenutzerDaoImplTest.java,v 1.3 2009/03/21 20:59:11 sgrossnw Exp $
 */
package de.evjnw.jlk.work.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.h2.util.FileUtils;

import de.evjnw.jlk.data.Benutzer;
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

}
