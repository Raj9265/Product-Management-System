package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.ProductDao;
import com.model.Product;
import com.model.User;
import com.service.UserService;

@Controller
public class MainController {

	@Autowired
	private ProductDao dao;

	 @Autowired
	 private UserService userService;
	
	@RequestMapping(value = "start.html", method = RequestMethod.GET)
    public ModelAndView start(HttpSession session) {
	        if (session.getAttribute("loggedInUser") == null) {
	            return new ModelAndView("redirect:/login.html");
	        }
	        return new ModelAndView("menu");
	    }
	
	@RequestMapping(value="index1.html" , method = RequestMethod.GET)
	public ModelAndView load()
	{
		return new ModelAndView("add_product_form", "key1" , new Product());
	}
	
	
	@RequestMapping(value="handle-product.html" , method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Product product )
	{
		dao.insert(product);
		return new ModelAndView("redirect:/search.html");
	}
	
	@RequestMapping(value = "search.html", method = RequestMethod.GET)
	public ModelAndView Search() {

		List searchList = dao.search();
		return new ModelAndView("search", "SearchList", searchList);

	}
	
	
	@RequestMapping(value = "delete.html", method = RequestMethod.GET)
	public ModelAndView Delete(@ModelAttribute Product product, @RequestParam int id) {

		product.setId(id);
		dao.delete(product);
        
		return new ModelAndView("redirect:/search.html");

	}

	@RequestMapping(value = "edit.html", method = RequestMethod.GET)
	public ModelAndView Edit(@ModelAttribute Product product, @RequestParam int id) {

		product.setId(id);
		List editList = dao.edit(product);

		return new ModelAndView("update_form", "key2", editList.get(0));

	}
	
	
	
    // 	Login And Register
	
	@RequestMapping(value="register.html" , method = RequestMethod.GET)
	public ModelAndView showRegister()
	{
		return new ModelAndView("register", "user" , new User());
	}
    
    @RequestMapping(value="register.html" , method = RequestMethod.POST)
	public ModelAndView register(@ModelAttribute("user") User user )
	{
    	userService.register(user);
		return new ModelAndView("redirect:/login.html");
	}

	@RequestMapping(value="login.html" , method = RequestMethod.GET)
	public ModelAndView showLogin()
	{
		 return new ModelAndView("login").addObject("msg", "Registered Succesfully");
	}
	    
    @RequestMapping(value = "login.html", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam("username") String username,@RequestParam("password") String password,HttpSession session) {
    	
    	User user = userService.validateUser(username, password);
        if (user != null) {
            session.setAttribute("loggedInUser", user);
            return new ModelAndView("redirect:/start.html");
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Invalid username or password");
            return modelAndView;
        }

	}
    
    @RequestMapping(value="logout.html" , method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session)
	{
    	 session.invalidate();
		 return new ModelAndView("duplicate");
	}
	
}
