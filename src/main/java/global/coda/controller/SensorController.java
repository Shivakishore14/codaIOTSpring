package global.coda.controller;

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

import global.coda.model.Company;
import global.coda.model.Sensor;
import global.coda.model.SensorData;
import global.coda.model.Session;
import global.coda.service.SensorService;

@Controller
@RequestMapping(path="/sensor")
public class SensorController {
	@Autowired
	private SensorService sensorService;
	
	@Autowired
	private Session session;
	
	@RequestMapping(path="/emulator", method=RequestMethod.GET)
	public String showEmulator() {
		return "emulator";
	}
	
	@PostMapping("/emulator/data")
	public ModelAndView putEmulatorValue(@Valid @ModelAttribute SensorData sensorData) {
		Company company = session.getLastCompany();
		JSONObject jo = sensorService.putData(sensorData, company);
		return new ModelAndView("json","json", jo);
	}
	@GetMapping("/emulator/data")
	public ModelAndView getEmulatorValue(@RequestParam int id) {
		Sensor sensor = new Sensor();
		sensor.setSid(id);
		JSONObject jo = sensorService.getSensorData(sensor);
		return new ModelAndView("json","json", jo);
	}
}
