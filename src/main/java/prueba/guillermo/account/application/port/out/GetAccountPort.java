package prueba.guillermo.account.application.port.out;

import prueba.guillermo.account.domain.Account;

public interface GetAccountPort {

	Account getAccount(Long accountId);
	
}
