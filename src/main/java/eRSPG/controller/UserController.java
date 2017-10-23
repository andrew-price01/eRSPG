package eRSPG.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import eRSPG.Repository.UserDAO;
import eRSPG.model.User;

@Controller
public class UserController {
	
	/**
	 * Dependency injection for data access objects.
	 * 
	 */
	
	@Autowired
	private UserDAO userDAO;
	
	
	
	@RequestMapping(value="/users/getAllUsers", method=RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers()
	{
		List<User> response = new ArrayList<User>();
		
		try {
			response = userDAO.findAllUser();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return response;
		
	}

}
