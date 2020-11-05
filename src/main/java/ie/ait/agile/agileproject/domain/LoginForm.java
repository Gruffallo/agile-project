package ie.ait.agile.agileproject.domain;



import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotNull
    @Size(min = 5, max = 15)
    private String username;

    @NotNull
    @Size(min = 5, max = 15)
    private String password;
}

