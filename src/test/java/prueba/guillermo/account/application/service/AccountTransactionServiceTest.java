package prueba.guillermo.account.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import prueba.guillermo.account.application.port.in.DepositCommand;
import prueba.guillermo.account.application.port.out.GetAccountPort;
import prueba.guillermo.account.application.port.out.UpdateAccountPort;
import prueba.guillermo.account.application.service.AccountTransactionService;
import prueba.guillermo.account.domain.Account;

class AccountTransactionServiceTest {

	private GetAccountPort getAccountPort = Mockito.mock(GetAccountPort.class);;
	private UpdateAccountPort updateAccountPort = Mockito.mock(UpdateAccountPort.class);;

	@Test
	void serviceAccountValidDespoitMustGetAccountAndUpdate() {
		Long accountId = 1L;
		BigDecimal amount = BigDecimal.valueOf(50.0);
		Account account = Mockito.mock(Account.class);

		doReturn(account).when(getAccountPort).getAccount(Mockito.same(accountId));
		doReturn(true).when(account).deposit(Mockito.same(amount));

		AccountTransactionService service = new AccountTransactionService(getAccountPort, updateAccountPort);

		Boolean result = service.deposit(new DepositCommand(accountId, amount));

		verify(updateAccountPort).updateAccount(Mockito.same(account));
		assertThat(result).isTrue();
	}
	
	@Test
	void serviceAccountInValidDespoitMustGetAccountAndUpdate() {
		Long accountId = 1L;
		BigDecimal amount = BigDecimal.valueOf(50.0);
		Account account = Mockito.mock(Account.class);

		doReturn(account).when(getAccountPort).getAccount(Mockito.same(accountId));
		doReturn(false).when(account).deposit(Mockito.same(amount));

		AccountTransactionService service = new AccountTransactionService(getAccountPort, updateAccountPort);

		Boolean result = service.deposit(new DepositCommand(accountId, amount));

		verify(updateAccountPort, never()).updateAccount(Mockito.same(account));
		assertThat(result).isFalse();
	}

	
	@Test
	void serviceAccountValidWithdrawMustGetAccountAndUpdate() {
		Long accountId = 1L;
		BigDecimal amount = BigDecimal.valueOf(50.0);
		Account account = Mockito.mock(Account.class);

		doReturn(account).when(getAccountPort).getAccount(Mockito.same(accountId));
		doReturn(true).when(account).deposit(Mockito.same(amount));

		AccountTransactionService service = new AccountTransactionService(getAccountPort, updateAccountPort);

		Boolean result = service.deposit(new DepositCommand(accountId, amount));

		verify(updateAccountPort).updateAccount(Mockito.same(account));
		assertThat(result).isTrue();
	}

	
	@Test
	void serviceAccountInValidWithdrawMustGetAccountAndUpdate() {
		Long accountId = 1L;
		BigDecimal amount = BigDecimal.valueOf(50.0);
		Account account = Mockito.mock(Account.class);

		doReturn(account).when(getAccountPort).getAccount(Mockito.same(accountId));
		doReturn(false).when(account).deposit(Mockito.same(amount));

		AccountTransactionService service = new AccountTransactionService(getAccountPort, updateAccountPort);

		Boolean result = service.deposit(new DepositCommand(accountId, amount));

		verify(updateAccountPort, never()).updateAccount(Mockito.same(account));
		assertThat(result).isFalse();
	}


}
