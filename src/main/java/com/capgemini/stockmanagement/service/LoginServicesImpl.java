package com.capgemini.stockmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.stockmanagement.dao.LoginDao;
import com.capgemini.stockmanagement.dto.LoginBean;
import com.capgemini.stockmanagement.exception.LoginException;

@Service
public class LoginServicesImpl implements LoginServices {

	@Autowired
	private LoginDao dao;

	@Override
	public LoginBean findCredentials(LoginBean bean) throws LoginException {
		try {
			LoginBean bean2 = dao.findAccount(bean.getId());
			return bean2;
		} catch (Exception e) {
			throw new LoginException("Account Doesnt Exists");
		}

	}

	@Override
	public boolean add(LoginBean bean) throws LoginException {
		try {
			if (dao.findAccount(bean.getId()) == null) {
				dao.delete(bean.getId());
			}
		} catch (Exception e) {
			throw new LoginException("Account Doesnt Exists!!!");
		}
		return false;
	}

	@Override
	public boolean delete(int id) throws LoginException {
		try {
			if (dao.findAccount(id) != null) {
			if (dao.delete(id)) {
				return true;
			}
			}
		}

		catch (Exception e) {
			throw new LoginException("Account doesnt exists!!!!");
		}

		return false;
	}

	@Override
	public boolean update(LoginBean bean) throws LoginException {
		try {
			if (dao.findCredentials(bean) != null) {
				try {
					if (dao.update(bean)) {
						return true;
					}
				} catch (Exception e) {
					throw new LoginException("Something went Wrong");
				}

			}
		} catch (Exception e) {
			throw new LoginException("Account Doesnt exist!!!!");
		}
		return false;
	}

	@Override
	public int auth(LoginBean bean) throws LoginException {
		try {
			if (dao.findCredentials(bean).getEmailId().equals(bean.getEmailId())) {
				try {
					if (dao.findCredentials(bean).getPassword().equals(bean.getPassword())) {
						return dao.findCredentials(bean).getRole();
					}
				} catch (Exception e) {
					throw new LoginException("Password Invalid");
				}
			}
		} catch (Exception e) {
			throw new LoginException("Email Id Invalid");
		}
		return 0;

	}

}
