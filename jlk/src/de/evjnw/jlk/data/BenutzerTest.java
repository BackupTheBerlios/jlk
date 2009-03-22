package de.evjnw.jlk.data;

import junit.framework.TestCase;

public class BenutzerTest extends TestCase {

	public void testBenutzer() {
		Benutzer b=new Benutzer();
		assertNull("Hat keinen Vornamen",b.getVorname());
		assertNotNull("Hat eine Favoritenliste",b.getFavoriten());
	}

	public void testBenutzerStringString() {
		Benutzer b=new Benutzer("Hans","Meier");
		assertEquals("Hans", b.getVorname());
		assertEquals("Meier", b.getNachname());
	}

	public void testAddFavoriten() {
		fail("Not yet implemented");
	}

}
