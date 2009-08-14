package de.evjnw.jlk.work.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.evjnw.jlk.data.Anhang;
import de.evjnw.jlk.data.Lied;
import de.evjnw.jlk.data.Material;

import de.evjnw.jlk.work.dao.LiedDao;
import junit.framework.TestCase;

public class LiedDaoImplTest extends TestCase {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(LiedDaoImplTest.class);

	/** zu testende Komponente. */
	private LiedDao component;
	SessionFactory sf;

	protected void setUp() throws Exception {
		DaoFactoryImpl factory = new DaoFactoryImpl("sa", "");
		component = factory.getLiedDao();
		sf = factory.factory;
	}

	protected void tearDown() {
		Session sess = sf.getCurrentSession();
		Transaction t = sess.beginTransaction();
		sess.createSQLQuery("SHUTDOWN").executeUpdate();
		t.commit();

	}

	@SuppressWarnings("unchecked")
	public void testListe() {
		component.startTransaction();
		List a = component.liste();
		component.commitTransaction();
		assertNotNull(a);
	}

	public void testSpeicher() {
		component.startTransaction();
		Lied a = new Lied();
		Material b=new Material();
		Anhang ang=new Anhang();
		ang.setAkkordart("Blub");
		ang.setBeschreibung("dies ist eine Beschreibung");
		a.setInterpret("Wusa");
		b.setArt("BLub");
		b.setBuch("Blubbuch");
		b.addAnhang(ang);
		a.addMaterial(b);
		assertEquals("Liedname im Material stimmt",a,b.getLied());
		component.speicher(a);
		
		component.commitTransaction();

	}

	public void testLade() {
		component.startTransaction();
		Lied a = component.lade(1);
		assertNotNull("Lied mit ID=1 kann nicht geladen werden", a);
	}
	@SuppressWarnings("unchecked")
	public void testLademitMaterial() {
		int i;
		component.startTransaction();
		Lied a = component.lade(1);
		List mat=a.getMaterial();
		for(i=0;i<mat.size();i++){
			Material m=(Material) mat.get(i);
			assertNotNull(m.getAnhang());
		}
		assertNotNull("Material kann nicht gelesen werden.",a.getMaterial());
		assertNotNull("Anhang kann nicht gelesen werden.");
		assertNotNull("Lied mit ID=1 kann nicht geladen werden", a);
	}
}
