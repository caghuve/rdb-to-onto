package br.ufpr.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.ufpr.bean.ObjectProperty;
import br.ufpr.util.Util;

public class ObjectPropertyDao extends GenericDao {

	@SuppressWarnings("unchecked")
	public List<ObjectProperty> listAll() {
		Session session = getSession();
		Transaction tx = null;
		List<ObjectProperty> retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(ObjectProperty.class);
			retorno = criteria.list();
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			session.close(); 
		}

		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<ObjectProperty> getByIndInverseFunctional(Boolean indInverseFunctional) {
		Session session = getSession();
		Transaction tx = null;
		List<ObjectProperty> retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(ObjectProperty.class);
			criteria.add(Restrictions.eq("indInverseFunctional", indInverseFunctional));
			retorno = criteria.list();
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			session.close(); 
		}

		return retorno;
	}
	
	@SuppressWarnings("unchecked")
	public List<ObjectProperty> getByIndInverseFunctionalAndMinCardinality(Boolean indInverseFunctional, Boolean minCardinality) {
		Session session = getSession();
		Transaction tx = null;
		List<ObjectProperty> retorno = null;

		try {
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(ObjectProperty.class);
			criteria.add(Restrictions.eq("indInverseFunctional", indInverseFunctional));
			criteria.add(Restrictions.eq("minCardinality", minCardinality));
			retorno = criteria.list();
			tx.commit();
		}
		catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			session.close(); 
		}

		return retorno;
	}
	
	@SuppressWarnings("rawtypes")
	public Boolean getObjectPropertyPKUK(Long id) throws SQLException {
		
		String pk = null, uk = null;
		String sql = "select t003.C003_IND_PRIMARY_KEY PK, t003.C003_IND_UNIQUE_KEY UK "
		+ " from  t019_object_property t019, t021_column_to_object_property t021, t003_column t003 "
		+ " where t019.c019_object_property_id = t021.c019_object_property_id "
		+ " and t003.C003_COLUMN_ID = t021.C003_COLUMN_ID "
		+ " and t019.c019_object_property_id =" + id ;
		
		
		ArrayList<Map> res = executeQuery(sql);
		Iterator<Map> iter = res.iterator();

		while(iter.hasNext()) {
			Map row = (Map) iter.next();
			pk = (Util.getNullText(row.get("PK")));
			uk = (Util.getNullText(row.get("UK")));
		} 

		if(pk.equals("true") || uk.equals("true")){
			return true;
		}else {
			return false;
		}
	}
}