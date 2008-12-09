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

   $Id: LiedTest.java,v 1.2 2008/12/09 07:54:20 ma08 Exp $
 */
package de.evjnw.jlk.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//import org.apache.log4j.Logger;

import junit.framework.TestCase;

/**
 * Ein UnitTest f&uuml;r die Attribute eines Liedes. 
 * @author Stephan
 *
 */
public class LiedTest extends TestCase {

	/** component under test */
	private Lied component;
//	private static final Logger log= Logger.getLogger(LiedTest.class);
	/**
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		component = new Lied();
		component.setTitel("Ein feste Burg ist unser Gott");
		component.setInterpret("Martin Luther");
		component.setThema("Vertrauen");
		String wer = "stephan";
		// eigentlich "Nummer" 362
		Material m1 = new Material(wer, "EG", 362);
		component.getMaterial().add(m1);
		// Aufgabe des Frameworks?
		component.setHinzugefuegtDurch(wer);
		component.setHinzugefuegtAm(new Date());
	}

	/**
	 * Test method for {@link de.evjnw.jlk.data.Lied#getTitel()}.
	 */
	public void testGetTitel() {
		assertNotNull(component.getTitel());
	//	log.info("Titel wurde erfolgreich gelesen");
	}

	/**
	 * Test method for {@link de.evjnw.jlk.data.Lied#setTitel(java.lang.String)}.
	 */
	public void testSetTitel() {
		String huhu = "Huhu";
		component.setTitel(huhu);
		assertEquals(huhu, component.getTitel());
	}

	/**
	 * Test method for {@link de.evjnw.jlk.data.Lied#getMaterial()}.
	 */
	public void testGetMaterial() {
		assertNotNull(component.getMaterial());
		assertFalse("die Liste der Materialien ist nicht leer", component.getMaterial().isEmpty());
	}

	/**
	 * Test method for {@link de.evjnw.jlk.data.Lied#getVerknuepfung()}.
	 */
	public void testGetVerknuepfung() {
		assertNotNull(component.getVerknuepfung());
		assertTrue("die Liste der Verknuepfungen ist leer", component.getVerknuepfung().isEmpty());
	}

	/**
	 * Test method for {@link de.evjnw.jlk.data.DataModell#getHinzugefuegtAm()}.
	 */
	public void testGetHinzugefuegtAm() {
		Date jetzt = new Date();
		System.out.println(jetzt);
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		System.out.println(df.format(jetzt));
		
		assertEquals("Dies ist der Fehlertext","hallo",component.getHinzugefuegtAm());
	
	}

	/**
	 * Test method for {@link de.evjnw.jlk.data.DataModell#setHinzugefuegtAm(int)}.
	 */
	public void testSetHinzugefuegtAm() {
		component.setHinzugefuegtAm(new Date());
		assertNotNull("Es ist ein Fehler aufgetreten",component.getHinzugefuegtAm());
	}

}
