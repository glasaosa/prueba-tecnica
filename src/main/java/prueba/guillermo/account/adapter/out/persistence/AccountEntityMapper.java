package prueba.guillermo.account.adapter.out.persistence;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import prueba.guillermo.account.domain.Account;

@Component
class AccountEntityMapper {

	public Account mapToDomain(AccountEntity account, BigDecimal balance) {
		return new Account(account.getId(), balance != null ? balance : BigDecimal.ZERO);
	}

	public AccountEntity mapToEntity(Account account) {
		return new AccountEntity(account.getId());
	}

}
