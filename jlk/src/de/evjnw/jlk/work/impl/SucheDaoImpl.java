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

   $Id: SucheDaoImpl.java,v 1.3 2009/10/06 20:20:52 sgrossnw Exp $
 */
package de.evjnw.jlk.work.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import de.evjnw.jlk.data.Benutzer;
import de.evjnw.jlk.data.Suche;
import de.evjnw.jlk.work.dao.DaoException;
import de.evjnw.jlk.work.dao.SucheDao;

public class SucheDaoImpl implements SucheDao {

	private SessionFactory factory;
	private Transaction transaction;

	public void commitTransaction() {
		transaction.commit();
		factory.getCurrentSession().close();

	}

	public Suche lade(int id) throws DaoException {

		Object o;
		try {
			Session session = factory.getCurrentSession();
			Criteria criteria = session.createCriteria(Suche.class);
			criteria.add(Restrictions.idEq(id));
			o = criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new DaoException("Fehler beim Laden des Suche mit id=" + id
					+ " : " + e.getMessage(), e);
		}
		if (o == null) {
			throw new DaoException("Keine Suche vorhanden mit id=" + id);
		}
		Suche suche = (Suche) o;
		suche.getBenutzer(); // TODO Dies verhindert das Lazyloading
		return suche;
	}

	@SuppressWarnings("unchecked")
	public List<Suche> liste() {

		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Benutzer.class);

		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Suche> liste(Benutzer b) {
		Session session = factory.getCurrentSession();
		Query q=session.createQuery("from Suche where Benutzer= :b)");
		q.setEntity("b", b);
		return q.list();
	}

	public void rollbackTransaction() {
		transaction.rollback();
		factory.getCurrentSession().close();
	}

	public void speicher(Suche b) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(b);

	}

	public void startTransaction() {
		Session session = factory.getCurrentSession();
		transaction = session.beginTransaction();

	}
	/**
	 * Dependency injection der Hibernate {@link SessionFactory}.
	 * 
	 * @param factory
	 *            the factory to set
	 */
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
}
