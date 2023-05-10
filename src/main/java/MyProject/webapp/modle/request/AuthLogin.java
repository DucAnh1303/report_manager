package MyProject.webapp.modle.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Data
public class AuthLogin {
    @NotBlank
    private String userName;

    @NotBlank
    private String password;
}
