package prueba.guillermo.user.adapter.out.account;

import java.util.Optional;

import org.springframework.stereotype.Component;

import prueba.guillermo.account.domain.Account;

@Component
class AccountMapper {

	public Optional<Long> mapToAccountId(Account account){
		return Optional.ofNullable(account).map(a -> a.getId());
	}
	
}
