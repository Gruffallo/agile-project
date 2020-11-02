package ie.ait.agile.agileproject.controller;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.service.GpService;
import ie.ait.agile.agileproject.service.HseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class practise {
	@Autowired
	private HseService hseService;
	

	@Autowired
	private GpService gpService;

	@RequestMapping("/")
	public String hello() {

		return "index";
	}

	@RequestMapping(value = "/hseLogin", method = RequestMethod.POST)
	public String hseLogin(@ModelAttribute("hsepassword") String password,
			@ModelAttribute("hseusername") String username, Model model) throws Exception {
		Hse hse = (Hse) hseService.hseDetails();
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
	
	

}
