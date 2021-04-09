package prueba.guillermo.user.application.service;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import prueba.guillermo.user.application.port.in.LoginCommand;
import prueba.guillermo.user.application.port.in.LoginUseCase;
import prueba.guillermo.user.application.port.out.ExistsUserCredentialsPort;

@Component
@AllArgsConstructor
class LoginService implements LoginUseCase {

	private final ExistsUserCredentialsPort existsUserCredentialsPort;

	@Override
	public Boolean userLogin(LoginCommand command) {
		return existsUserCredentialsPort.existsUserCredentials(command.getEmail(),
				PasswordUtils.hashPassword(command.getPassword()));
	}

}
