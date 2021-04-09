package prueba.guillermo.user.application.service;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import prueba.guillermo.user.application.port.in.InfoCommand;
import prueba.guillermo.user.application.port.in.InfoUseCase;
import prueba.guillermo.user.application.port.out.GetUserPort;
import prueba.guillermo.user.domain.User;

@Component
@AllArgsConstructor
class InfoService implements InfoUseCase {
	
	private final GetUserPort getUserPort;

	@Override
	public User userInfo(InfoCommand command) {
		return getUserPort.getUserByEmail(command.getUserEmail());
	}

}
