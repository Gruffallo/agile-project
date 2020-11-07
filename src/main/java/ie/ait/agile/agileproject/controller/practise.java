package ie.ait.agile.agileproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.service.GpService;
import ie.ait.agile.agileproject.service.HseService;
import ie.ait.agile.agileproject.service.PatientService;



@Controller
public class practise {
	@Autowired
	private HseService hseService;
	
	@Autowired
	private PatientService patientService;
	

	@Autowired
	private GpService gpService;

	@RequestMapping("/")
	public String hello() {

		return "index";
	}

	@RequestMapping(value = "/hseLogin", method = RequestMethod.POST)
	public String hseLogin(@ModelAttribute("hsepassword") String password,
			@ModelAttribute("hseusername") String username, Model model) throws Exception {
		Hse hse = hseService.hseDetails();
		System.out.println(username + " from html " + password);

		System.out.println(hse.getUsername() + " " + hse.getPassword());

//		if(hse.getUsername()!=username) {
//			model.addAttribute("invalidHseUsername", true);
//			return "index";
//		}
//		else if(hse.getPassword()!=password) {
//			model.addAttribute("invalidHsePassword", true);
//			return "index";
		// }

		if (hse.getUsername().equals(username.toString()) && hse.getPassword().equals(password.toString())) {
			model.addAttribute("hseLoginComplete", true);

			return "hsePage";
		} else {
			model.addAttribute("invalidDetails", true);
			return "index";
		}

	}

	@RequestMapping(value = "/gpLogin", method = RequestMethod.POST)
	public String gpLogin(@ModelAttribute("gppassword") String password, @ModelAttribute("gpusername") String username,
			Model model) throws Exception {
		Gp gp = gpService.details();
//		System.out.println(username+" from html "+password);
//		
//		System.out.println(hse.getUsername()+" "+hse.getPassword());

//		if(hse.getUsername()!=username) {
//			model.addAttribute("invalidHseUsername", true);
//			return "index";
//		}
//		else if(hse.getPassword()!=password) {
//			model.addAttribute("invalidHsePassword", true);
//			return "index";
		// }

		if (gp.getUsername().equals(username) && gp.getPassword().equals(password)) {
			model.addAttribute("hseLoginComplete", true);
			model.addAttribute("gpName", gp.getUsername());

			return "gpPage";
		} else {
			model.addAttribute("invalidGpDetails", true);
			return "index";
		}

	}
	@RequestMapping(value = "/patientLogin", method = RequestMethod.POST)
	public String patientLogin(@ModelAttribute("patientpassword") String password,
			@ModelAttribute("patientusername") String username, Model model) throws Exception {
		Patient patient = patientService.details();
		System.out.println(username + " from html " + password);

		System.out.println(patient.getUsername() + " " + patient.getPassword());

//		if(hse.getUsername()!=username) {
//			model.addAttribute("invalidHseUsername", true);
//			return "index";
//		}
//		else if(hse.getPassword()!=password) {
//			model.addAttribute("invalidHsePassword", true);
//			return "index";
		// }

		if (patient.getUsername().equals(username.toString()) && patient.getPassword().equals(password.toString())) {
			model.addAttribute("patient0LoginComplete", true);

			return "patientPage";
		} else {
			model.addAttribute("invalidPatientDetails", true);
			return "index";
		}

	}
	
	

}
