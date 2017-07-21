package global.coda.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import global.coda.dao.CompanyDao;
import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.Session;
import global.coda.model.User;
import global.coda.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private Session session;
	
	@RequestMapping(path = "/listUsers", method = RequestMethod.GET)
	public ModelAndView listUsers() {
		Company company = session.getLastCompany();
		
		JSONObject jo = companyService.listUsers(company);
		return new ModelAndView("json", "json", jo);
	}
	
	@RequestMapping(path="/listSensors", method = RequestMethod.GET)
	public ModelAndView listSensor() {
		Company company = session.getLastCompany();
		
		JSONObject jo= companyService.listSensor(company);
		
		return new ModelAndView("json", "json", jo);
	}
	@PostMapping("/set")
	public ModelAndView selectCompany(@RequestParam int cid) {
		Company company = companyService.getCompany(cid);
		session.setLastCompany(company);
		Company c1 = session.getLastCompany();
		return new ModelAndView("json", "json", c1.toJSON());
	}
	@GetMapping("/isAdmin")
	public ModelAndView isAdmin() {
		Company company = session.getLastCompany();
		User user = session.getUser();
		JSONObject jo = companyService.isAdmin(company, user);
		return new ModelAndView("json", "json", jo);
	}
	@PostMapping("/new")
	public ModelAndView newCompany(@Valid @ModelAttribute Company company) {
		JSONObject jo = companyService.createCompany(company);
		if (jo.get("message").equals("done")) {
			User user = session.getUser();
			jo = companyService.addUser(company, user, "admin");
		}
		return new ModelAndView("json", "json", jo);
	}
	@PostMapping("/addSensor")
	public ModelAndView addSensor(@Valid @ModelAttribute Sensor sensor) {
		JSONObject jo = companyService.addSensor(sensor);
		return new ModelAndView("json", "json", jo);
	}
	@PostMapping("/addUser")
	public ModelAndView addSensor(@RequestParam String email) {
		Company company = session.getLastCompany();
		User user = new User();
		user.setEmail(email);
		JSONObject jo = companyService.addUser(company, user, "user");
		return new ModelAndView("json", "json", jo);
	}
}
