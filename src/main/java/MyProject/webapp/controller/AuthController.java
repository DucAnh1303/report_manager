package MyProject.webapp.controller;

import MyProject.webapp.config.filter.JwtToken;
import MyProject.webapp.modle.request.AuthLogin;
import MyProject.webapp.modle.response.BaseResponse;
import MyProject.webapp.response.AuthResponse;
import MyProject.webapp.service.auth.AuthConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    @Autowired
    private AuthConfig authConfig;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private JwtToken jwtToken;

    @PostMapping("/api/login")
    public ResponseEntity<BaseResponse<Object>> user(@Valid @RequestBody AuthLogin authLogin) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authLogin.getUserName(), authLogin.getPassword()));
            UserDetails userDetails = authConfig.loadUserByUsername(authLogin.getUserName());
            String token = jwtToken.generateToken(userDetails);
            String refreshToken = jwtToken.generateRefreshToken(userDetails);
            return ResponseEntity.status(HttpStatus.OK).body(new BaseResponse<>(HttpStatus.OK.value(), "login success", new AuthResponse(token, refreshToken)));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping("/api/refresh-token")
    public ResponseEntity<Object> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        try {
            String accessToken = jwtToken.getUserNameFromJWT(refreshToken);
            UserDetails userDetails = authConfig.loadUserByUsername(accessToken);
            String newToken = jwtToken.generateToken(userDetails);
            return ResponseEntity.status(HttpStatus.OK).body(newToken);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
