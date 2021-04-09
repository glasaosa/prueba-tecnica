package prueba.guillermo.account.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import prueba.guillermo.account.application.port.out.CreateAccountPort;
import prueba.guillermo.account.application.service.AccountCreationService;
import prueba.guillermo.account.domain.Account;

class AccountCreationServiceTest {

	private final CreateAccountPort createAccountPort = Mockito.mock(CreateAccountPort.class);
	
	@Test
	public void createAccountMustCallCreateAccountPort() {
		Account portAccount = new Account(1L, BigDecimal.ZERO);
		
		doReturn(portAccount).when(createAccountPort).createAccount();

		AccountCreationService accountCreationService = new AccountCreationService(createAccountPort);
		Account account = accountCreationService.createAccount();

		assertThat(account).isEqualTo(portAccount);
	}

}
