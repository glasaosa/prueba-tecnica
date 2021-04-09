package prueba.guillermo.user.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import prueba.guillermo.user.application.port.in.InfoCommand;
import prueba.guillermo.user.application.port.out.GetUserPort;
import prueba.guillermo.user.application.service.InfoService;
import prueba.guillermo.user.domain.User;

class InfoServiceTest {

	private final GetUserPort getUserPort = Mockito.mock(GetUserPort.class);

	@Test
	public void getUserInfoMustCallGetUserPort() {
		String email = "email@test.com";
		User portUser = new User(1L, email, 2L);

		doReturn(portUser).when(getUserPort).getUserByEmail(Mockito.same(email));

		InfoService infoService = new InfoService(getUserPort);
		User user = infoService.userInfo(new InfoCommand(email));

		assertThat(user).isEqualTo(portUser);
	}

}
