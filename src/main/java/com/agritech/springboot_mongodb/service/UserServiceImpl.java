package com.agritech.springboot_mongodb.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agritech.springboot_mongodb.dao.UsersDAO;
import com.agritech.springboot_mongodb.document.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UsersDAO dao;
	
	@Override
	public void createUsers(List<Users> user) {
		dao.saveAll(user);
	}

	@Override
	public Optional<Users> findUserById(int id) {
		return dao.findById(id);
	}
	
	@Override
	public Collection<Users> getAllUsers() {
		return dao.findAll();
	}

	@Override
	public void deleteUserById(int id) {
		dao.deleteById(id);
	}

	@Override
	public void updateUser(Users user) {
		dao.save(user);
	}

	@Override
	public void deleteAllUsers() {
		dao.deleteAll();
	}

}
