package com.cg.service;

import com.cg.entity.User;
import com.cg.repository.IUserRepository;
import com.cg.repository.UserRepositoryImpl;

public class UserServiceImpl implements IUserService {
	IUserRepository userRepo;
	public UserServiceImpl() {
		userRepo = new UserRepositoryImpl();
	}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userRepo.login(user);
	}
	@Override
	public User logout(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
