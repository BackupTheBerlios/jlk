package de.evjnw.jlk.data;

import junit.framework.TestCase;

public class ZusammenstellungTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testZusammenstellungBasic(){
		Zusammenstellung zs=new Zusammenstellung();
		zs.setTitel("Testtitel1");
		zs.setBeschreibung("Beschreibung");
		assertNotNull("Titel konnte nicht gelesen werden",zs.getTitel());
		assertNotNull("Beschreibung konnte nicht gelesen werden",zs.getBeschreibung());
	}
	public void testZusammenstellung() {
		Zusammenstellung zs=new Zusammenstellung();
		Anhang anhang=new Anhang();
		anhang.setAkkordart("Test1");
		zs.addAnhang(anhang);
		assertNotNull("Hat keinen Titel",zs.getTitel());
		assertNotNull("Hat keine Anhangsliste",zs.getAnhang());
	}

	public void testAddAnhang() {
		Zusammenstellung zs=new Zusammenstellung();
		zs.setBeschreibung("Test1");
		zs.setTitel("Titeltest");
		Anhang ang=new Anhang();
		ang.setAkkordart("DMoll");
		zs.addAnhang(ang);
	}
	public void testReadFavoriten() {
		Zusammenstellung zs=new Zusammenstellung();
		assertNotNull("Anhänge konnten nicht gelesen werden.", zs.getAnhang());
	}
}
