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

   $Id: DaoFactoryImpl.java,v 1.11 2009/09/05 10:31:55 sgrossnw Exp $
 */
package de.evjnw.jlk.work.impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.LazyInitializationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.SAXException;

import de.evjnw.jlk.work.DatabaseHandle;
import de.evjnw.jlk.work.dao.AnhangDao;
import de.evjnw.jlk.work.dao.BenutzerDao;
import de.evjnw.jlk.work.dao.DaoConfigurationException;
import de.evjnw.jlk.work.dao.DaoException;
import de.evjnw.jlk.work.dao.DaoFactory;
import de.evjnw.jlk.work.dao.LiedDao;
import de.evjnw.jlk.work.dao.SucheDao;

/**
 * Diese Klasse bietet die Hibernate-basierte Implementierung der
 * {@link DaoFactory}. Sie implementiert auch das <em>Factory Pattern</em> und
 * hilft so bei der Strukturierung der Applikation.
 * Das {@link DatabaseHandle} wird vorerst hier implementiert, könnte jedoch 
 * von einer eigenen Klasse übernommen werden, die dann fertig initialisierte
 * {@link DaoFactoryImpl} Instanzen zurückgibt (TODO: umschalten zwischen DB).
 * 
 * @author Stephan
 */
public class DaoFactoryImpl implements DaoFactory, DatabaseHandle {

	/** Der Logger. */
	private static final Logger LOG = Logger.getLogger(DaoFactoryImpl.class);

	/** 
	 * Hierüber werden die Hibernate-Verbindungen bezogen.
	 */
	SessionFactory factory;

	/**
	 * Speichert, ob die DAO Factory initialisiert wurde.
	 */
	private boolean initialized = false;
	
	/**
	 * Mit diesem Flag könnnen wir steuern, ob während der Entwicklungsphase
	 * automatisch die Datenbank-Skripte erzeugt werden sollen.
	 */
	private boolean exportSchemaForTests = false;

	/**
	 * Benutzer DAO.
	 */
	private BenutzerDaoImpl benutzerDao;
	/**
	 * Anhang DAO.
	 */
	private AnhangDaoImpl anhangDao;
	/**
	 * DAO für die Suche.
	 */
	private SucheDaoImpl sucheDao;

	/**
	 * DAO für Lieder.
	 */
	private LiedDaoImpl liedDao;

	/**
	 * @param user
	 *            technischer Benutzer an der Datenbank
	 * @param password
	 *            Passwort des technischen Benutzers an der Datenbank
	 * @throws DaoConfigurationException 
	 * 			wenn bei der Verarbeitung der Hibernate Configuration ein Fehler auftritt
	 */
	public DaoFactoryImpl(String user, String password) throws DaoConfigurationException {
		// TODO: user und password merken?
	}

	/** 
	 * Liest die Hibernate-Konfiguration ein und stellt die DB-Verbindung her.
	 */
	private void initializeFactory() {
		// TODO: sollte eigentlich eine Ressource im Classpath sein
		File f = new File("hibernate.cfg.xml");
		Configuration configuration = new Configuration().configure(f);

		// funktioniert noch nicht, da der Parser versucht, die DTD (per HTTP) aufzulösen, 
		// ich muss hier mit Unterstützung der API den Entity Resolver für einen lokalen
		// Catalog konfigurieren
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		Document d = null;
//		try {
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			EntityResolver er = null;
//			db.setEntityResolver(er);
//			InputStream is = getClass().getResourceAsStream("/hibernate.cfg.xml");
//			if (is == null) {
//				throw new DaoConfigurationException("the configuration was not found on the classpath");
//			}
//			d = db.parse(is);
//		} catch (ParserConfigurationException e) {
//			throw new DaoConfigurationException("could not initialize XML parser:"+e.getMessage(), e);
//		} catch (SAXException e) {
//			throw new DaoConfigurationException(e);
//		} catch (IOException e) {
//			throw new DaoConfigurationException("could not access the hibernate configuration:"+e.getMessage(), e);
//		}
//		Configuration configuration = new Configuration().configure(d);
		
		// TODO: Benutzer und Passwort in der Configuration ersetzen
		
		// configuration.setInterceptor(new LastModifiedInterceptor());

		if (exportSchemaForTests) {
			SchemaExport export = new SchemaExport(configuration);
			export.setOutputFile("create_jlk.sql");
			boolean writeScript = true;
			boolean executeDdl = true;
			export.create(writeScript, executeDdl);
		}

		factory = configuration.buildSessionFactory();

		benutzerDao = new BenutzerDaoImpl();
		anhangDao = new AnhangDaoImpl();
		sucheDao = new SucheDaoImpl();
		liedDao = new LiedDaoImpl();
		benutzerDao.setFactory(factory);
		anhangDao.setFactory(factory);
		sucheDao.setFactory(factory);
		liedDao.setFactory(factory);
		// TODO: die anderen DAOs initialisieren
	}

	/**
	 * @see de.evjnw.jlk.work.dao.DaoFactory#getBenutzerDao()
	 */
	public BenutzerDao getBenutzerDao() {
		lazyInitialization();
		return benutzerDao;
	}

	/** 
	 * Führt eine späte Initialisierung der Datenbank (bei Bedarf) durch.
	 * Hierüber wird es (später) möglich, eine neue Datenbank anzulegen
	 * und die DB-Verbindung erst nach gestarteter Anwendung herzustellen.
	 */
	private synchronized void lazyInitialization() {
		if (! initialized) {
			LOG.info("lazy initialization of DAO factory");
			initializeFactory();
			initialized = true;
		}
	}

	/**
	 * @see de.evjnw.jlk.work.dao.DaoFactory#getAnhangDao()
	 */
	public AnhangDao getAnhangDao() {
		lazyInitialization();
		return anhangDao;
	}
	public SucheDao getSucheDao() {
		lazyInitialization();
		return sucheDao;
	}
	public LiedDao getLiedDao() {
		lazyInitialization();
		return liedDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public void close() {
		LOG.info("close");
		try {
			synchronized (this) {
				if (initialized) {
					Session sess = factory.getCurrentSession();
					Transaction t = sess.beginTransaction();
					sess.createSQLQuery("SHUTDOWN").executeUpdate();
					t.commit();
					// sess.close();
					initialized = false;
					factory = null;
				} else {
					LOG.info("not initialized yet");
				}
			}
		} catch (HibernateException he) {
			throw new DaoException(
					"konnte kein SHUTDOWN an die HsqlDB absetzen:"
							+ he.getMessage(), he);
		}
	}
}
