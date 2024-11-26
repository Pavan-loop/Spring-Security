package com.madara.security.authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Firstname should not be empty")
    @NotBlank(message = "Firstname should not be empty")
    private String firstname;
    @NotEmpty(message = "Lastname should not be empty")
    @NotBlank(message = "Lastname should not be empty")
    private String lastname;
    @NotEmpty(message = "Email should not be empty")
    @NotBlank(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Password should not be empty")
    @NotBlank(message = "Password should not be empty")
    @Size(min = 8, message = "Password size should be more than 8")
    private String password;
}
