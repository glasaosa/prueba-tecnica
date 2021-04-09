package prueba.guillermo.user.adapter.out.account;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import prueba.guillermo.account.application.port.in.CreateAccountUseCase;
import prueba.guillermo.user.application.port.out.CreateAccountPort;

@Component
@AllArgsConstructor
class AccountAdapter implements CreateAccountPort {

	private final AccountMapper accountMapper;
	private final CreateAccountUseCase createAccountUseCase;

	@Override
	public Long createAccount() {
		return accountMapper.mapToAccountId(createAccountUseCase.createAccount()).orElseThrow(InternalError::new);
	}

}
