package com.capgemini.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.CompanyBean;
import com.capgemini.stockmanagement.dto.ManagerBean;
import com.capgemini.stockmanagement.exception.LoginException;
import com.capgemini.stockmanagement.exception.ManagerException;

@Repository
public class ManagerDaoImpl implements ManagerDao {

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public boolean addManager(ManagerBean bean) {

		try {
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(bean);
			entityTransaction.commit();
			entityManager.close();
			return true;
		} catch (Exception e) {

			throw new ManagerException("User Already Exists!!!");
		}

	}@Override
	public boolean updateManager(ManagerBean bean) {

		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="update ManagerBean set managerName=:managerName,companyName=:companyName,companyId=:companyId,emailId=:emailId,address=:address where id=:id";
			Query q=emManager.createQuery(jpql);

			q.setParameter("managerName", bean.getManagerName());
			q.setParameter("companyName", bean.getCompanyName());
			q.setParameter("companyId", bean.getCompanyId());
			q.setParameter("emailId", bean.getEmailId());
			q.setParameter("address", bean.getAddress());
			q.setParameter("id", bean.getId());			
			int result=q.executeUpdate();
			etTransaction.commit();
			emManager.close();

			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteManager(int id) {
		try{
			EntityManager emManager=entityManagerFactory.createEntityManager();
			EntityTransaction etTransaction=emManager.getTransaction();
			etTransaction.begin();
			String jpql="delete from ManagerBean where id=:id";
			Query query=emManager.createQuery(jpql);
			query.setParameter("id", id);
			int result=query.executeUpdate();
			etTransaction.commit();
			emManager.close();
			if(result>0) {
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ManagerBean findManager(int id) {

		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from ManagerBean where id=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("id", id);
			ManagerBean bean2 = (ManagerBean) query.getSingleResult();
			entityManager.close();
			return bean2;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new LoginException("User Id Not Found");
		}
	}

	@Override
	public ManagerBean findManagerByName(String name) {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from ManagerBean where managerName=:managerName";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("managerName", name);
			ManagerBean bean = (ManagerBean) query.getSingleResult();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new LoginException("User Id Not Found");
		}
	}

	@Override
	public List<ManagerBean> findAllManager() {
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			String jpql = "from ManagerBean";
			Query query = entityManager.createQuery(jpql);
			List<ManagerBean> bean = query.getResultList();
			entityManager.close();
			return bean;
		} catch (Exception e) {
			throw new LoginException("User Id Not Found");
		}
	}

}
