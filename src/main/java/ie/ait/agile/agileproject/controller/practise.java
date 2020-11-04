package ie.ait.agile.agileproject.controller;

import ie.ait.agile.agileproject.domain.LoginForm;
import ie.ait.agile.agileproject.entity.Gp;
import ie.ait.agile.agileproject.entity.Hse;
import ie.ait.agile.agileproject.service.GpService;
import ie.ait.agile.agileproject.service.HseService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class practise {

    private final HseService hseService;
    private final GpService gpService;

    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @PostMapping("/hseLogin")
    public String hseLogin(LoginForm login, Model model) {
        String username = login.getUsername();
        String password = login.getPassword();
        Hse hse = hseService.hseDetails();

        System.out.println(username + " from html " + password);
        System.out.println(hse.getUsername() + " " + hse.getPassword());
        boolean isUsernamesEqual = hse.getUsername().equals(username);
        boolean isPasswordsEqual = hse.getPassword().equals(password);

        if (isUsernamesEqual && isPasswordsEqual) {
            model.addAttribute("hseLoginComplete", true);
            return "hsePage";
        } else {
            model.addAttribute("invalidDetails", true);
            return "index";
        }

    }

    @PostMapping("/gpLogin")
    public String gpLogin(LoginForm login, Model model) {
        Gp gp = gpService.details();
        boolean isUsernamesEqual = gp.getUsername().equals(login.getUsername());
        boolean isPasswordsEqual = gp.getPassword().equals(login.getPassword());


        if (isUsernamesEqual && isPasswordsEqual) {
            model.addAttribute("gpLoginComplete", true);
            model.addAttribute("gpName", gp.getUsername());

            return "gpPage";
        } else {
            model.addAttribute("invalidGpDetails", true);
            return "index";
        }
    }
}
