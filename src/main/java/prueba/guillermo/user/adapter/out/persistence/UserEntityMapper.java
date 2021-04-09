package prueba.guillermo.user.adapter.out.persistence;

import org.springframework.stereotype.Component;

import prueba.guillermo.user.domain.User;

@Component
class UserEntityMapper {

	User mapToDomain(UserEntity user) {
		return new User(user.getId(), user.getEmail(), user.getAccountId());
	}

}
