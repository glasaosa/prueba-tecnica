package prueba.guillermo.user.application.port.in;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class InfoCommand {

	@NotNull
	private final String userEmail;

}
