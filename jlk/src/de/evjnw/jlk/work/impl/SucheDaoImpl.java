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

}
