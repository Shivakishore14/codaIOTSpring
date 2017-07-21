package global.coda.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import global.coda.model.Company;
import global.coda.model.Session;
import global.coda.model.User;
import global.coda.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private Session session;
	

	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping("/login")
	public ModelAndView loginGET() {
		User user = new User();
		return new ModelAndView("login", "user", user);
	}
	@PostMapping("/login")
	public String loginPOST(@Valid @ModelAttribute User user, BindingResult result) {
		if (result.hasErrors())
			return "login";
		
		user = userService.isValidLogin(user);
		session.setUser(user);
	    
		logger.info("inside login :"+user.getId());
		//System.out.println("inside login :"+user.getId());
		
		if (session.isLoggedin())
			return "redirect:dashboard";
		else
			return "redirect:login?invalid=wrong email or password";
	}
	@GetMapping("/logout")
    public String logout(HttpSession session) {
      session.invalidate();
      return "redirect:login";
    }
	@GetMapping(path = "/signup")
	public ModelAndView SignupGet() {
		User user = new User();
		return new ModelAndView("signup", "user", user);
	}
	
	@PostMapping("/signup")
	public String signupPOST(@Valid @ModelAttribute User user, BindingResult result) {
		if (result.hasErrors())
			return "signup";
		logger.info("trying to signup");
		user = userService.createUser(user);
		if (user.getEmail() != null)
			return "redirect:signup?resp=done";
		else
			return "redirect:signup?resp=try%20again";
	}
	
	@GetMapping("/dashboard")
	public ModelAndView dashboardGET() {
		
		if (!session.isLoggedin())
			return new ModelAndView("redirect:login?invalid=please%20login");
		
		User user = session.getUser();
		//System.out.println("dash :"+user.getId());

		JSONObject jo = userService.listCompany(user);
		Map<String, JSONObject> map = new HashMap<String, JSONObject>();
		map.put("user", user.toJSON());
		map.put("companyList", jo);
		return new ModelAndView("dashboard","data", map);
	}
}
