package ie.ait.agile.agileproject.controller;

import ie.ait.agile.agileproject.domain.Credentials;
import ie.ait.agile.agileproject.domain.Login;
import ie.ait.agile.agileproject.entity.*;
import ie.ait.agile.agileproject.exception.ExceptionHandler;
import ie.ait.agile.agileproject.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class practise {

    private final HseService hseService;
    private final PatientService patientService;
    private final GpService gpService;
    private final PharmacistService pharmaService;
    private final OSMService osmService;

    practise(HseService hseService, PatientService patientService, GpService gpService,PharmacistService pharmaService,OSMService osmService) {
        this.hseService = hseService;
        this.patientService = patientService;
        this.gpService = gpService;
        this.osmService=osmService;
        this.pharmaService=pharmaService;
    }


    @GetMapping("/")
    public String hello(Model model) {

        model.addAttribute("login", new Login());
        return "index";
    }

    @PostMapping("/hseLogin")
    public String hseLogin(@Valid Login login, Model model, @ModelAttribute Credentials credentials) {
        String loginUser = login.getUsername();
        String loginPwd = login.getPassword();

        Hse hse = hseService.hseDetails(loginUser);
        String hseUser = hse.getUsername();
        String hsePwd = hse.getPassword();

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
    public String gpLogin(@Valid Login login, Model model) {
        String loginUser = login.getUsername();
        String loginPwd = login.getPassword();

        Gp gp = gpService.details(loginUser);
        String gpUser = gp.getUsername();
        String gpPwd = gp.getPassword();

        if (gpUser.equals(loginUser) && gpPwd.equals(loginPwd)) {
            model.addAttribute("hseLoginComplete", true);
            model.addAttribute("login", login);
            return "gpPage";
        } else {
            model.addAttribute("invalidGpDetails", true);
            return "index";
        }

    }

    @PostMapping("/patientLogin")
    public String patientLogin(@Valid Login login, Model model) {
        String loginUser = login.getUsername();
        String loginPwd = login.getPassword();

        Patient patient = patientService.details(loginUser);
        String patientUser = patient.getUsername();
        String patientPwd = patient.getPassword();

        System.out.println(loginUser + " from HTML " + loginPwd);
        System.out.println(patientUser + " from DB " + patientPwd);

        if (patientUser.equals(loginUser) && patientPwd.equals(loginPwd)) {
            model.addAttribute("patientLoginComplete", true);
            model.addAttribute("login", login);
            model.addAttribute("patient", patient);
            return "patientPage";
        } else {
            model.addAttribute("invalidPatientDetails", true);
            return "index";
        }
    }

    @PostMapping("/pharmacistLogin")
    public String pharmacistLogin(@Valid Login login, Model model) {
        String loginUser = login.getUsername();
        String loginPwd = login.getPassword();

        Pharmacist pharma = pharmaService.details(loginUser);
        String pharmaUser = pharma.getUsername();
        String pharmaPwd = pharma.getPassword();

        System.out.println(loginUser + " from HTML " + loginPwd);
        System.out.println(pharmaUser + " from DB " + pharmaPwd);

        if (pharmaUser.equals(loginUser) && pharmaPwd.equals(loginPwd)) {
            model.addAttribute("pharmaLoginComplete", true);
//            model.addAttribute("login",  login);
            return "pharmacistPage";
        } else {
            model.addAttribute("invalidPharmaDetails", true);
            return "index";
        }
    }
    @PostMapping("/osmLogin")
    public String osmLogin(@Valid Login login, Model model) {
       String loginUser = login.getUsername();
        String loginPwd = login.getPassword();

        OSM osm = osmService.details(loginUser);
        String osmUser = osm.getUsername();
        String osmPwd = osm.getPassword();

//        System.out.println(loginUser + " from HTML " + loginPwd);
//        System.out.println(patientUser + " from DB " + patientPwd);

        if (osmUser.equals(loginUser) && osmPwd.equals(loginPwd)) {
            model.addAttribute("osmLoginComplete", true);
            model.addAttribute("login", login);
            return "osmPage";
        } else {
            model.addAttribute("invalidOsmDetails", true);
            return "index";
        }
    }


    @PostMapping("/createAdmin")
    public String createHse(@Valid Credentials credentials, Model model) throws Exception {

        String username = credentials.getUsername();
        String password = credentials.getPassword();
        String name = credentials.getName();
        String email = credentials.getEmail();
        String badgeNo = credentials.getBadgeNo();


        Hse admin = new Hse();

        admin.setName(name);
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setEmail(email);
        admin.setBadgeNo(badgeNo);
        admin.setActive(true);


        if (hseService.findByUsername(username) != null) {
            model.addAttribute("hseUsernameExist", true);

        } else if (hseService.findByEmail(email) != null) {

            model.addAttribute("hseEmailExist", true);
        } else if (hseService.findByBadgeNo(badgeNo) != null) {
            System.out.println("Badge doesnt");
            model.addAttribute("hseBadgeExist", true);
        } else {
            model.addAttribute("credentials", new Credentials());

            System.out.println(admin.getName());
            System.out.println(admin.getUsername());
            System.out.println(admin.getPassword());
            System.out.println(admin.getEmail());
            System.out.println(admin.getBadgeNo());
            System.out.println(admin.isActive());


            hseService.createHse(admin);
            model.addAttribute("hseCreated",true);


        }


        return "hsePage";


    }


    @PostMapping("/createGp")
    public String createGp(@Valid Credentials credentials, Model model) throws Exception {

        String username = credentials.getUsername();
        String password = credentials.getPassword();
        String name = credentials.getName();
        String email = credentials.getEmail();
        String badgeNo = credentials.getBadgeNo();



        Gp gp= new Gp();
        gp.setActive(true);
        gp.setName(name);
        gp.setUsername(username);
        gp.setPassword(password);
        gp.setBadgeNo(badgeNo);
        gp.setEmail(email);


//        System.out.println(gp.getName());
//        System.out.println(gp.getUsername());
//        System.out.println(gp.getPassword());
//        System.out.println(gp.getEmail());
//        System.out.println(gp.getBadgeNo());
//        System.out.println(gp.isActive());



        if (gpService.findByUsername(username) != null) {
            model.addAttribute("gpUsernameExist", true);

        } else if (gpService.findByEmail(email) != null) {

            model.addAttribute("gpEmailExist", true);
        } else if (gpService.findByBadgeNo(badgeNo) != null) {
            System.out.println("Badge doesnt");
            model.addAttribute("gpBadgeExist", true);
        } else {
            model.addAttribute("credentials", new Credentials());





            hseService.createGp(gp);
            model.addAttribute("gpCreated",true);


        }


        return "hsePage";



    }


    @PostMapping("/createPharmacist")
    public String createPharmacist(@Valid Credentials credentials, Model model) throws Exception {

        String username = credentials.getUsername();
        String password = credentials.getPassword();
        String name = credentials.getName();
        String email = credentials.getEmail();
        String badgeNo = credentials.getBadgeNo();


        Pharmacist pharma= new Pharmacist();
        pharma.setActive(true);
        pharma.setBadgeNo(badgeNo);
        pharma.setUsername(username);
        pharma.setPassword(password);
        pharma.setEmail(email);
        pharma.setBadgeNo(badgeNo);




        if (pharmaService.findByUsername(username) != null) {
            model.addAttribute("pharmaUsernameExist", true);

        } else if (pharmaService.findByEmail(email) != null) {

            model.addAttribute("pharmaEmailExist", true);
        } else if (pharmaService.findByBadgeNo(badgeNo) != null) {
//            System.out.println("Badge doesnt");
            model.addAttribute("pharmaBadgeExist", true);
        } else {
            hseService.createPharmacist(pharma);
            model.addAttribute("credentials", new Credentials());
            model.addAttribute("pharmaCreated",true);

        }


        return "hsePage";



    }


    @PostMapping("/createOsm")
    public String createOsm(@Valid Credentials credentials, Model model) throws Exception {

        String username = credentials.getUsername();
        String password = credentials.getPassword();
        String name = credentials.getName();
        String email = credentials.getEmail();
        String badgeNo = credentials.getBadgeNo();


        OSM osm= new OSM();
            osm.setActive(true);
            osm.setBadgeNo(badgeNo);
            osm.setEmail(email);
            osm.setUsername(username);
            osm.setPassword(password);
            osm.setName(name);



        if (osmService.findByUsername(username) != null) {
            model.addAttribute("osmUsernameExist", true);

        } else if (osmService.findByEmail(email) != null) {

            model.addAttribute("osmEmailExist", true);
        } else if (osmService.findByBadgeNo(badgeNo) != null) {
//            System.out.println("Badge doesnt");
            model.addAttribute("osmBadgeExist", true);
        } else {
            hseService.createOsm(osm);
            model.addAttribute("credentials", new Credentials());
            model.addAttribute("osmCreated",true);

        }


        return "hsePage";



    }




}
