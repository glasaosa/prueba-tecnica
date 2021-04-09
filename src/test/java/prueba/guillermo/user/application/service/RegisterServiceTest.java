package prueba.guillermo.user.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import prueba.guillermo.user.application.port.in.RegisterCommand;
import prueba.guillermo.user.application.port.out.CreateAccountPort;
import prueba.guillermo.user.application.port.out.CreateUserPort;
import prueba.guillermo.user.application.service.PasswordUtils;
import prueba.guillermo.user.application.service.RegisterService;
import prueba.guillermo.user.domain.User;

class RegisterServiceTest {
	private final CreateAccountPort createAccountPort = Mockito.mock(CreateAccountPort.class);
	private final CreateUserPort createUserPort = Mockito.mock(CreateUserPort.class);

	@Test
	public void getUserInfoMustCallGetUserPort() {
		String email = "email@test.com";
		String password = "password";
		Long accountId = 1L;

		User portUser = new User(1L, email, accountId);

		doReturn(accountId).when(createAccountPort).createAccount();
		doReturn(portUser).when(createUserPort).createUser(Mockito.same(email),
				Mockito.eq(PasswordUtils.hashPassword(password)), Mockito.same(accountId));

		RegisterService registerService = new RegisterService(createAccountPort, createUserPort);
		User user = registerService.userRegister(new RegisterCommand(email, password));

		verify(createAccountPort).createAccount();
		assertThat(user).isEqualTo(portUser);
	}

}
