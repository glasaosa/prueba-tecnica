package prueba.guillermo.user.application.port.out;

import prueba.guillermo.user.domain.User;

public interface GetUserPort {

	User getUser(Long userId);
	
	User getUserByEmail(String email);

}
