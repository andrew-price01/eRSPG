package eRSPG.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import eRSPG.Repository.UserDAO;
import eRSPG.Repository.UserRoleDAO;
import eRSPG.model.User;
import eRSPG.model.UserRole;

@Controller
public class UserController {
	
	/**
	 * Dependency injection for data access objects.
	 * 
	 */
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private UserRoleDAO userRoleDAO;
	
	
	
	@RequestMapping(value="/users/getAllUsers", method=RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() throws Exception
	{
		List<User> response = new ArrayList<User>();
		
		try {
			response = userDAO.findAllUser();
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error finding all users: " + ex.getMessage());
		}
		
		return response;
		
	}
	
	
	@RequestMapping(value="/users/getUserRoles", method=RequestMethod.GET)
	public @ResponseBody UserRole getUserRoles(int userId) throws Exception {
		UserRole response = new UserRole();
		
		try {
			response = userRoleDAO.findUserRoleById(userId);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error getting user roles for userId: " + userId + "\nError: " + ex.getMessage());
		}
		
		return response;
	}
	
	
	@RequestMapping(value="/users/addUserRole", method=RequestMethod.PUT)
	public @ResponseBody String addUserRole(@RequestParam("roleTypeId") int roleTypeId, @RequestParam("userId") int userId) throws Exception {

		
		try {
			UserRole ra = new UserRole();
			
			ra.setRoleTypeId(roleTypeId);
			ra.setUserId(userId);
			ra.setRevoked(LocalDateTime.now());
			ra.setUpdatedAt(LocalDateTime.now());
			
			userRoleDAO.addNewOrUpdateUserRole(ra);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error adding user role: (roleTypeId: " + roleTypeId + ", userId: " + userId + ")\n" + ex.getMessage());
		}
		
		return "SUCCESS";
	}
	
	
	@RequestMapping(value="/users/deleteUserRole", method=RequestMethod.DELETE)
	public @ResponseBody String deleteUserRole(@RequestParam("roleTypeId") int roleTypeId, @RequestParam("userId") int userId) throws Exception {
		
		try {
			UserRole ra = new UserRole();
			
			ra.setRoleTypeId(roleTypeId);
			ra.setUserId(userId);
			
			userRoleDAO.deleteUserRole(ra);
		}catch(Exception ex) {
			ex.printStackTrace();
			throw new Exception("Error deleting role: (roleTypeId: " + roleTypeId + ", userId: " + userId + ")\n" + ex.getMessage());
		}
		
		return "SUCCESS";
	}

}
