package prueba.guillermo.user.application.service;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import prueba.guillermo.user.application.port.in.RegisterCommand;
import prueba.guillermo.user.application.port.in.RegisterUseCase;
import prueba.guillermo.user.application.port.out.CreateAccountPort;
import prueba.guillermo.user.application.port.out.CreateUserPort;
import prueba.guillermo.user.domain.User;

@Component
@AllArgsConstructor
class RegisterService implements RegisterUseCase {

	private final CreateAccountPort createAccountPort;
	private final CreateUserPort createUserPort;

	@Override
	public User userRegister(RegisterCommand command) {
		final Long accountId = createAccountPort.createAccount();

		return createUserPort.createUser(command.getEmail(), 
				PasswordUtils.hashPassword(command.getPassword()), accountId);
	}

}
