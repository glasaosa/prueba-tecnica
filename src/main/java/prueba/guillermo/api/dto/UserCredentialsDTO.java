package prueba.guillermo.api.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class UserCredentialsDTO {

	@NotNull
	@Email(message = "Email should be valid")
	private final String email;
	
	@NotBlank
	private final String password;
	
}
