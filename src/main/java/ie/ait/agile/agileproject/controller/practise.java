package ie.ait.agile.agileproject.controller;

import ie.ait.agile.agileproject.domain.Credentials;
import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.entity.Patient;
import ie.ait.agile.agileproject.service.GpService;
import ie.ait.agile.agileproject.service.HseService;
import ie.ait.agile.agileproject.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class practise {

    private final HseService hseService;
    private final PatientService patientService;
    private final GpService gpService;

    practise(HseService hseService, PatientService patientService, GpService gpService) {
        this.hseService = hseService;
        this.patientService = patientService;
        this.gpService = gpService;
    }


    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("credentials", new Credentials());
        return "index";
    }

    @PostMapping("/hseLogin")
    public String hseLogin(@Valid Credentials credentials, Model model) {
        var loginUser = credentials.getUsername();
        var loginPwd = credentials.getPassword();

        Hse hse = hseService.hseDetails();
        var hseUser = hse.getUsername();
        var hsePwd = hse.getPassword();

        System.out.println(loginUser + " from HTML " + loginPwd);
        System.out.println(hseUser + " from DB " + hsePwd);

        if (hseUser.equals(loginUser) && hsePwd.equals(loginPwd)) {
            model.addAttribute("hseLoginComplete", true);
            model.addAttribute("credentials", credentials);
            return "hsePage";
        } else {
            model.addAttribute("invalidDetails", true);
            return "index";
        }

    }

    @PostMapping("/gpLogin")
    public String gpLogin(@Valid Credentials credentials, Model model) {
        var loginUser = credentials.getUsername();
        var loginPwd = credentials.getPassword();

        Gp gp = gpService.details();
        var gpUser = gp.getUsername();
        var gpPwd = gp.getPassword();

        if (gpUser.equals(loginUser) && gpPwd.equals(loginPwd)) {
            model.addAttribute("hseLoginComplete", true);
            model.addAttribute("credentials", credentials);
            return "gpPage";
        } else {
            model.addAttribute("invalidGpDetails", true);
            return "index";
        }

    }

    @PostMapping("/patientLogin")
    public String patientLogin(@Valid Credentials credentials, Model model) {
        var loginUser = credentials.getUsername();
        var loginPwd = credentials.getPassword();

        Patient patient = patientService.details();
        var patientUser = patient.getUsername();
        var patientPwd = patient.getPassword();

        System.out.println(loginUser + " from HTML " + loginPwd);
        System.out.println(patientUser + " from DB " + patientPwd);

        if (patientUser.equals(loginUser) && patientPwd.equals(loginPwd)) {
            model.addAttribute("patient0LoginComplete", true);
            model.addAttribute("credentials", credentials);
            return "patientPage";
        } else {
            model.addAttribute("invalidPatientDetails", true);
            return "index";
        }
    }

}
