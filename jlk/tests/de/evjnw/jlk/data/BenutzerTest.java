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
		Benutzer b=new Benutzer();
		b.setNachname("Wurst");
		b.setVorname("Ida");
		Favoriten fav=new Favoriten();
		fav.setBewertung(10);
		b.addFavoriten(fav);
	}
	public void testReadFavoriten() {
		Benutzer b=new Benutzer();
		b.setNachname("Wurst2");
		b.setVorname("Ida2");
		assertNotNull("Favoriten konnten nicht gelesen werden.", b.getFavoriten());
	}
	public void testaddSuche(){
		Benutzer b=new Benutzer("Jul","Koma");
		Suche search=new Suche("From Termin");
		b.addSuche(search);
		assertNotNull("Suchen können nicht gelesen werden", b.getSuche());
		}
}
