package ie.ait.agile.agileproject.controller;

import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.service.GpService;
import ie.ait.agile.agileproject.service.HseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequiredArgsConstructor
public class practise {
    private final HseService hseService;
    private final GpService gpService;

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

        if (gp.getUsername().equals(username) && gp.getPassword().equals(password)) {
            model.addAttribute("gpLoginComplete", true);
            model.addAttribute("gpName", gp.getUsername());

            return "gpPage";
        } else {
            model.addAttribute("invalidGpDetails", true);
            return "index";
        }

    }


}
