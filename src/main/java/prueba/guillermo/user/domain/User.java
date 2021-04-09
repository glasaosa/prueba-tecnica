package prueba.guillermo.user.domain;

import lombok.Value;

@Value
public class User {

	private final Long id;
	
	private final String email;

	private final Long accountId;

}
