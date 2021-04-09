package prueba.guillermo.user.adapter.out.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query("select u from UserEntity u where u.email = :email")
	Optional<UserEntity> findOneByEmail(@Param("email") String email);
	
	@Query("select count(u) from UserEntity u where u.email = :email and u.password = :password")
	Long countUserByCredentials(@Param("email") String email, @Param("password") String password);

}
