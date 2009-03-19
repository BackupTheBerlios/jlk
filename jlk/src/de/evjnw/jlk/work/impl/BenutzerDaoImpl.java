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

   $Id: BenutzerDaoImpl.java,v 1.2 2009/03/19 22:09:02 sgrossnw Exp $
 */
package de.evjnw.jlk.work.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import de.evjnw.jlk.data.Benutzer;
import de.evjnw.jlk.work.dao.BenutzerDao;
import de.evjnw.jlk.work.dao.DaoException;

/**
 * Diese Klasse bietet die Hibernate-basierte Implementierung
 * des {@link BenutzerDao}.
 * 
 * @author Stephan
 */
public class BenutzerDaoImpl implements BenutzerDao {

	private SessionFactory factory;
	private Transaction transaction;

	/**
	 * @see de.evjnw.jlk.work.dao.BenutzerDao#lade(int)
	 */
	public Benutzer lade(int id) throws DaoException {
		Object o;
		try {
			Session session = factory.getCurrentSession();
			Criteria criteria = session.createCriteria(Benutzer.class);
			criteria.add(Restrictions.idEq(id));
			o = criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new DaoException("Fehler beim Laden des Benutzers mit id="+id+" : "+e.getMessage(), e);
		}
		if (o == null) {
			throw new DaoException("Kein Benutzer vorhanden mit id="+id);
		}
		return (Benutzer) o;
	}

	/**
	 * @see de.evjnw.jlk.work.dao.BenutzerDao#liste()
	 */
	@SuppressWarnings("unchecked")
	public List<Benutzer> liste() {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Benutzer.class);
		return criteria.list();
	}

	/**
	 * @see de.evjnw.jlk.work.dao.BenutzerDao#speicher(de.evjnw.jlk.data.Benutzer)
	 */
	public void speicher(Benutzer b) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(b);
	}

	// common transaction handling 
	
	/**
	 * @see de.evjnw.jlk.work.dao.BenutzerDao#commitTransaction()
	 */
	public void commitTransaction() {
		transaction.commit();
		factory.getCurrentSession().close();
	}

	/**
	 * @see de.evjnw.jlk.work.dao.BenutzerDao#rollbackTransaction()
	 */
	public void rollbackTransaction() {
		transaction.rollback();
		factory.getCurrentSession().close();
	}

	/**
	 * @see de.evjnw.jlk.work.dao.BenutzerDao#startTransaction()
	 */
	public void startTransaction() {
		Session session = factory.getCurrentSession();
		transaction = session.beginTransaction();
	}

	/**
	 * Dependency injection der Hibernate {@link SessionFactory}.
	 * @param factory the factory to set
	 */
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

}
