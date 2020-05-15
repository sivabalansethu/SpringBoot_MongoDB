package com.agritech.springboot_mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.agritech.springboot_mongodb.document.Users;

@Repository
public interface UsersDAO extends MongoRepository<Users, Integer>{

}