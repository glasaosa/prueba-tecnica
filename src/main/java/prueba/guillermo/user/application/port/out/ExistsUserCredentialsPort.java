package prueba.guillermo.user.application.port.out;

public interface ExistsUserCredentialsPort {

	Boolean existsUserCredentials(String email, String password);

}
