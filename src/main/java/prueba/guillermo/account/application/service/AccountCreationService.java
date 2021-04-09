package prueba.guillermo.account.application.service;

import lombok.AllArgsConstructor;
import prueba.guillermo.account.application.port.in.CreateAccountUseCase;
import prueba.guillermo.account.application.port.out.CreateAccountPort;
import prueba.guillermo.account.domain.Account;

import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class AccountCreationService implements CreateAccountUseCase {

	private final CreateAccountPort createAccountPort;

	@Override
	public Account createAccount() {
		return createAccountPort.createAccount();
	}

}
