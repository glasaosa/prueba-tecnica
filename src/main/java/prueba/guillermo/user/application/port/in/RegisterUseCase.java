package prueba.guillermo.user.application.port.in;

import prueba.guillermo.user.domain.User;

public interface RegisterUseCase {

	User userRegister(RegisterCommand command);

}
