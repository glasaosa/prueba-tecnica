package prueba.guillermo.user.adapter.out.persistence;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import prueba.guillermo.user.application.port.out.CreateUserPort;
import prueba.guillermo.user.application.port.out.ExistsUserCredentialsPort;
import prueba.guillermo.user.application.port.out.GetUserPort;
import prueba.guillermo.user.domain.User;

@Component
@AllArgsConstructor
class UserPersistenceAdapter implements GetUserPort, CreateUserPort, ExistsUserCredentialsPort {

	private final UserEntityMapper userMapper;
	private final UserRepository userRepository;

	@Override
	public User getUser(Long userId) {
		final UserEntity user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);

		return userMapper.mapToDomain(user);
	}

	@Override
	public User getUserByEmail(String email) {
		final UserEntity user = userRepository.findOneByEmail(email).orElseThrow(EntityNotFoundException::new);

		return userMapper.mapToDomain(user);
	}

	@Override
	public User createUser(String email, String password, Long accountId) {
		final UserEntity user = userRepository.save(new UserEntity(null, email, password, accountId));

		return userMapper.mapToDomain(user);
	}

	@Override
	public Boolean existsUserCredentials(String email, String password) {
		return 1 <= userRepository.countUserByCredentials(email, password);
	}

}
