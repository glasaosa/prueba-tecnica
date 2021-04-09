package prueba.guillermo.user.application.port.out;

import prueba.guillermo.user.domain.User;

public interface CreateUserPort {

	User createUser(String email, String password, Long accountId);

}
