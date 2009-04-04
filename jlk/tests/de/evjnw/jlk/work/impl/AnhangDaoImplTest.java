package de.evjnw.jlk.work.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import de.evjnw.jlk.data.Anhang;
import de.evjnw.jlk.work.dao.AnhangDao;
import junit.framework.TestCase;

public class AnhangDaoImplTest extends TestCase {

	private static final Logger log = Logger.getLogger(AnhangDaoImplTest.class);

	/** zu testende Komponente. */
	private AnhangDao component;
	SessionFactory sf;

	protected void setUp() throws Exception {
		DaoFactoryImpl factory = new DaoFactoryImpl("sa", "");
		component = factory.getAnhangDao();
		sf = factory.factory;
	}

	protected void tearDown() {
		Session sess = sf.getCurrentSession();
		Transaction t = sess.beginTransaction();
		sess.createSQLQuery("SHUTDOWN").executeUpdate();
		t.commit();

	}

	public void testListe() {
		component.startTransaction();
		List<Anhang> a = component.liste();
		component.commitTransaction();
		assertNotNull(a);
	}

	public void testSpeicher() {
		component.startTransaction();
		Anhang a = new Anhang();
		a.setAkkordart("Blub");
		a.setBeschreibung("Dies ist ein Test");
		a.setGesang("Mehrstimmig");
		a.setNotensatz("Klavierauszug");
		component.speicher(a);
		component.commitTransaction();

	}

	public void testLade() {
		component.startTransaction();
		Anhang a = component.lade(1);
		assertNotNull("Anhang mit ID=1 kann nicht geladen werden", a);
	}
}
