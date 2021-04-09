package prueba.guillermo.user.application.port.in;

import prueba.guillermo.user.domain.User;

public interface InfoUseCase {

	User userInfo(InfoCommand command);

}
