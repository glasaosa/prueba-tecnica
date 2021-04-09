package prueba.guillermo.user.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import prueba.guillermo.user.application.port.in.LoginCommand;
import prueba.guillermo.user.application.port.out.ExistsUserCredentialsPort;
import prueba.guillermo.user.application.service.LoginService;
import prueba.guillermo.user.application.service.PasswordUtils;

class LoginServiceTest {

	private final ExistsUserCredentialsPort existsUserCredentialsPort = Mockito.mock(ExistsUserCredentialsPort.class);

	@Test
	public void getUserLoginMustCallExistsUserCredentialsPort() {
		String email = "email@test.com";
		String password = "password";
		Boolean portResult = true;

		doReturn(portResult).when(existsUserCredentialsPort).existsUserCredentials(Mockito.same(email),
				Mockito.eq(PasswordUtils.hashPassword(password)));

		LoginService loginService = new LoginService(existsUserCredentialsPort);
		Boolean result = loginService.userLogin(new LoginCommand(email, password));

		assertThat(result).isEqualTo(portResult);
	}

}
