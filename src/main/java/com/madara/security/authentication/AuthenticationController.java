package com.madara.security.authentication;

import com.madara.security.user.Role;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> registerUser(
            @RequestBody
            @Valid
            RegistrationRequest request,
            @RequestParam("role") String role
    ) {
        Role convToRole = Role.valueOf(role.toUpperCase());
        authenticationService.registerUser(request, convToRole);
        return ResponseEntity.accepted().build();
    }
}
