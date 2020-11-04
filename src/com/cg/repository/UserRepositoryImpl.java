package com.cg.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.User;

public class UserRepositoryImpl implements IUserRepository {
	EntityManager manager;
	public UserRepositoryImpl() {
		EntityManagerFactory f = Persistence.createEntityManagerFactory("JPA-PU");
		manager= f.createEntityManager();
}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		user=manager.find(User.class, user.getUserid());
		if(user!=null) {
			return user;
		}
		return null;
	}
	@Override
	public User logout(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
