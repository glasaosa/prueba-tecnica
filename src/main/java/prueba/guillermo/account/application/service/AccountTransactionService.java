package prueba.guillermo.account.application.service;

import lombok.AllArgsConstructor;
import prueba.guillermo.account.application.port.in.DepositCommand;
import prueba.guillermo.account.application.port.in.DepositUseCase;
import prueba.guillermo.account.application.port.in.WithdrawCommand;
import prueba.guillermo.account.application.port.in.WithdrawUseCase;
import prueba.guillermo.account.application.port.out.GetAccountPort;
import prueba.guillermo.account.application.port.out.UpdateAccountPort;
import prueba.guillermo.account.domain.Account;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
@Transactional
@AllArgsConstructor
class AccountTransactionService implements DepositUseCase, WithdrawUseCase {

	private final GetAccountPort getAccountPort;
	private final UpdateAccountPort updateAccountPort;

	@Override
	public boolean deposit(DepositCommand command) {
		Account account = getAccountPort.getAccount(command.getAccountId());
		
		if(account.deposit(command.getAmount())) {
			updateAccountPort.updateAccount(account);
			
			return true;
		}
		return false;
	}
	
	@Override
	public boolean withdraw(WithdrawCommand command) {
		Account account = getAccountPort.getAccount(command.getAccountId());
		
		if(account.withdraw(command.getAmount())) {
			updateAccountPort.updateAccount(account);
			
			return true;
		}
		return false;
	}

}
