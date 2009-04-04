/* 
   JLK - Java Lieder Katalog
   Copyright 2008-2009, Mario Aldag

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

   $Id: LiedDaoImpl.java,v 1.1 2009/04/04 18:01:53 ma08 Exp $
 */
package de.evjnw.jlk.work.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import de.evjnw.jlk.data.Lied;
import de.evjnw.jlk.work.dao.DaoException;
import de.evjnw.jlk.work.dao.LiedDao;

public class LiedDaoImpl implements LiedDao {

	private SessionFactory factory;
	private Transaction transaction;

	public Lied lade(int id) throws DaoException {

		Object o;
		try {
			Session session = factory.getCurrentSession();
			Criteria criteria = session.createCriteria(Lied.class);
			criteria.add(Restrictions.idEq(id));
			o = criteria.uniqueResult();
		} catch (HibernateException e) {
			throw new DaoException("Fehler beim Laden des Liedes mit id=" + id
					+ " : " + e.getMessage(), e);
		}
		if (o == null) {
			throw new DaoException("Kein Lied vorhanden mit id=" + id);
		}
		Lied anhang = (Lied) o;

		return anhang;
	}

	@SuppressWarnings("unchecked")
	public List<Lied> liste() {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Lied.class);

		return criteria.list();
	}

	public void speicher(Lied b) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(b);
	}

	// common transaction handling

	
	public void commitTransaction() {
		transaction.commit();
		factory.getCurrentSession().close();
	}

	
	public void rollbackTransaction() {
		transaction.rollback();
		factory.getCurrentSession().close();
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
