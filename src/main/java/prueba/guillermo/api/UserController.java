package prueba.guillermo.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import prueba.guillermo.api.dto.TokenResponse;
import prueba.guillermo.api.dto.UserCredentialsDTO;
import prueba.guillermo.commons.JWTUtils;
import prueba.guillermo.user.application.port.in.LoginCommand;
import prueba.guillermo.user.application.port.in.LoginUseCase;
import prueba.guillermo.user.application.port.in.RegisterCommand;
import prueba.guillermo.user.application.port.in.RegisterUseCase;
import prueba.guillermo.user.domain.User;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
class UserController {

	private final LoginUseCase loginUseCase;
	private final RegisterUseCase registerUseCase;

	@PostMapping(path = "/register")
	public ResponseEntity<Void> register(@Valid @RequestBody UserCredentialsDTO userCredentials) {
		User user = registerUseCase
				.userRegister(new RegisterCommand(userCredentials.getEmail(), userCredentials.getPassword()));

		return (user != null && user.getId() != null ? ResponseEntity.ok()
				: ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)).build();
	}

	@PostMapping(path = "/login")
	public ResponseEntity<TokenResponse> login(@Valid @RequestBody UserCredentialsDTO userCredentials) {
		return loginUseCase.userLogin(new LoginCommand(userCredentials.getEmail(), userCredentials.getPassword()))
				? ResponseEntity.ok(new TokenResponse(JWTUtils.generateJWTWithEmail(userCredentials.getEmail())))
				: ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}

}