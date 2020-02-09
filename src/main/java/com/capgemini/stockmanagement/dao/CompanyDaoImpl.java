package com.capgemini.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.CompanyBean;
import com.capgemini.stockmanagement.exception.CompanyException;
import com.capgemini.stockmanagement.exception.LoginException;
@Repository
public class CompanyDaoImpl implements CompanyDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addCompany(CompanyBean bean) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bean);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {
			throw new CompanyException("Email Id Already Exists");
		}

	}

	@Override
	public boolean deleteCompany(int id) {
		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "delete from CompanyBean where id=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			int i = query.executeUpdate();
			if (i != 1) {
				return false;
			} else {
				return true;
			}

		} catch (Exception e) {
			throw new CompanyException("Email Id Dosent exist");
		}
	}

	@Override
	public CompanyBean findCompany(int id) {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from LoginBean where id=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			CompanyBean bean2 = (CompanyBean) query.getSingleResult();
			return bean2;
		} catch (Exception e) {
			throw new LoginException("User Id Not Found");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CompanyBean> getAllCompany() {

		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from CompanyBean";
			Query query = entityManager.createQuery(jpql);
			List<CompanyBean> bean = query.getResultList();
			return bean;
		} catch (Exception e) {
			throw new LoginException("User Id Not Found");
		}
	}

	@Override
	public CompanyBean findCompanyByName(String name) {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from CompanyBean where name=:name";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("name", name);
			CompanyBean bean = (CompanyBean) query.getSingleResult();
			return bean;
		} catch (Exception e) {
			throw new LoginException("User Id Not Found");
		}
	}
}
