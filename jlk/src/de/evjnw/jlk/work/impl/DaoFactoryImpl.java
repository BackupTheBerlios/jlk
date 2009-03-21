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

   $Id: DaoFactoryImpl.java,v 1.3 2009/03/21 15:28:06 ma08 Exp $
 */
package de.evjnw.jlk.work.impl;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import de.evjnw.jlk.work.dao.BenutzerDao;
import de.evjnw.jlk.work.dao.DaoFactory;

/**
 * Diese Klasse bietet die Hibernate-basierte Implementierung
 * der {@link DaoFactory}.
 * Sie implementiert auch das <em>Factory Pattern</em> und hilft
 * so bei der Strukturierung der Applikation. 
 * 
 * @author Stephan
 */
public class DaoFactoryImpl implements DaoFactory {

	private SessionFactory factory;
	
	/**
	 * Benutzer DAO.
	 */
	private BenutzerDaoImpl benutzerDao; 

	/**
	 * @param user  technischer Benutzer an der Datenbank
	 * @param password  Passwort des technischen Benutzers an der Datenbank
	 */
	public DaoFactoryImpl(String user, String password) {
		// TODO: sollte eigentlich eine Ressource im Classpath sein
		File f = new File("hibernate.cfg.xml");
		Configuration configuration =
            new Configuration().configure(f);
		// TODO: Benutzer und Passwort in der Configuration ersetzen
		
		//		configuration.setInterceptor(new LastModifiedInterceptor());
		/*
		SchemaExport export =
            new SchemaExport(configuration);
		export.create(false, true);
		*/
		factory = configuration.buildSessionFactory();
		
		benutzerDao = new BenutzerDaoImpl();
		benutzerDao.setFactory(factory);
		
		// TODO: die anderen DAOs initialisieren
	}
	
	/**
	 * @see de.evjnw.jlk.work.dao.DaoFactory#getBenutzerDao()
	 */
	public BenutzerDao getBenutzerDao() {
		return benutzerDao;
	}

}
