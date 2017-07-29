package com.capgemini.chess.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.dataaccess.UserDao;
import com.capgemini.chess.exception.UserProfileValidationException;
import com.capgemini.chess.service.UserProfileValidationService;
import com.capgemini.chess.service.to.UserProfileTO;
import com.capgemini.chess.service.to.UserUpdateTO;

@Service
public class UserProfileValidationServiceImpl implements UserProfileValidationService {

	UserDao userDao = null;
		
	@Autowired
	public UserProfileValidationServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	/*
	public void validateEmail(String email) throws UserProfileValidationException {
		UserProfileTO foundByEmail = userDao.findByEmail(email);
		if (foundByEmail != null) {
			throw new UserProfileValidationException("There is no user with that email.");
		}
	}
	*/
	/*
	public void validateId(Long id) throws UserProfileValidationException {
		UserProfileTO foundById = userDao.findById(id);
		if (foundById != null) {
			throw new UserProfileValidationException("There is no user with that ID.");
		}
	}
	*/
	public void validateLogin(String login) throws UserProfileValidationException {
		UserProfileTO foundByLogin = userDao.findByLogin(login);
		if (foundByLogin != null) {
			throw new UserProfileValidationException("There is no user with that Login.");
		}
	}
	
	@Override
	public void validateUserUpdate(UserUpdateTO userUpdateTO) throws UserProfileValidationException {
		// TODO Auto-generated method stub
		
		//UserProfileTO foundByLogin = userDao.findByLogin(userUpdateTO.getLifeMotto());
		validateLogin(userUpdateTO.getLifeMotto());
		
	}
	@Override
	public void validateId(Long id) throws UserProfileValidationException {
		UserProfileTO foundById = userDao.findById(id);
		if (foundById != null) {
			throw new UserProfileValidationException("There is no user with that Id.");
		}
		
	}
	
}
