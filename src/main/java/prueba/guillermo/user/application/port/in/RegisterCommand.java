package prueba.guillermo.user.application.port.in;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class RegisterCommand {

	@NotNull
	private final String email;

	@NotNull
	private final String password;

}
