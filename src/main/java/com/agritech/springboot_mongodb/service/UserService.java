package com.agritech.springboot_mongodb.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.agritech.springboot_mongodb.document.Users;

public interface UserService {
	
	public void createUsers(List<Users> user);
	public Collection<Users> getAllUsers();
	public Optional<Users> findUserById(int id);
	public void deleteUserById(int id);
	public void updateUser(Users user);
	public void deleteAllUsers();
	
}
