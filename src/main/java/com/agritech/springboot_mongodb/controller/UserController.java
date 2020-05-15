package com.agritech.springboot_mongodb.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agritech.springboot_mongodb.document.Users;
import com.agritech.springboot_mongodb.service.UserService;

@RestController
@RequestMapping(value="/api-mongo/user")
public class UserController {

	@Autowired
    UserService userService;
 
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value= "/createUsers")
    public String create(@RequestBody List<Users> user) {
	//public String create() {
        logger.debug("Saving Users.");
        // Hard Code Value
        //List<Users> usr = new ArrayList();
        //Users usrs1 = new Users(1, "RAJA 1", "Project Manager 1", 200000L);
        //Users usrs2 = new Users(2, "Sekar 1", "CTO 1", 500000L);
        //Users usrs3 = new Users(3, "Pandian 1", "CEO 1", 800000L);
        //usr.add(usrs1);
        //usr.add(usrs2);
        //usr.add(usrs3);
        
        //userService.createUsers(usr);
        userService.createUsers(user);
        
        //JSON FORMAT - From Postman
       /* [
	         {
	             "id": 1,
	             "name": "RAJA 1",
	             "teamName": "Project Manager 1",
	             "salary": 200000
	         },
	         {
	             "id": 2,
	             "name": "Sekar 1",
	             "teamName": "CTO 1",
	             "salary": 500000
	         },
	         {
	             "id": 3,
	             "name": "Pandian 1",
	             "teamName": "CEO 1",
	             "salary": 800000
	         }
	    ]*/
        
        return "Users are created.";
    }
	
	@GetMapping(value= "/getAllUsers")
    public Collection<Users> getAll() {
        logger.debug("Getting all Users.");
        return userService.getAllUsers();
    }
	
	@GetMapping(value= "/getUserById/{user-id}")
    public Optional<Users> getById(@PathVariable(value= "user-id") int id) {
        logger.debug("Getting User with user-id= {}.", id);
        return userService.findUserById(id);
    }
	
	@PutMapping(value= "/updateUser/{user-id}")
    public String update(@PathVariable(value= "user-id") int id, @RequestBody Users user) {
        logger.debug("Updating User with user-id= {}.", id);
        user.setId(id);
        userService.updateUser(user);
        return "User record for user-id= " + id + " updated.";
    }
	
	@DeleteMapping(value= "/deleteUser/{user-id}")
    public String delete(@PathVariable(value= "user-id") int id) {
        logger.debug("Deleting User with user-id= {}.", id);
        userService.deleteUserById(id);
        return "User record for user-id= " + id + " deleted.";
    }
 
    @DeleteMapping(value= "/deleteAllUsers")
    public String deleteAll() {
        logger.debug("Deleting all Users.");
        userService.deleteAllUsers();
        return "All Users are deleted.";
    }
}
