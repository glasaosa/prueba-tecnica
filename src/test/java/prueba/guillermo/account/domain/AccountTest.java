package prueba.guillermo.account.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import prueba.guillermo.account.domain.Account;

class AccountTest {

	@Test
	void initialBalanceAndLessWithdrawAllowed() {
		Long accountId = 1L;

		BigDecimal balance = BigDecimal.valueOf(500.0);
		BigDecimal withdraw = BigDecimal.valueOf(300.0);
		BigDecimal newBalance = balance.subtract(withdraw);

		Account account = new Account(accountId, balance);

		Boolean withdrawResult = account.withdraw(withdraw);

		BigDecimal balanceResult = account.getFinalBalance();

		assertThat(withdrawResult).isTrue();
		assertThat(balanceResult).isEqualTo(newBalance);
	}

	@Test
	void depositWithInitialBalanceAndLessWithdrawAllowed() {
		Long accountId = 1L;

		BigDecimal balance = BigDecimal.valueOf(500.0);
		BigDecimal deposit = BigDecimal.valueOf(300.0);
		BigDecimal withdraw = BigDecimal.valueOf(700.0);
		BigDecimal newBalance = balance.add(deposit).subtract(withdraw);

		Account account = new Account(accountId, balance);

		Boolean depositResult = account.deposit(deposit);
		Boolean withdrawResult = account.withdraw(withdraw);

		BigDecimal balanceResult = account.getFinalBalance();

		assertThat(depositResult).isTrue();
		assertThat(withdrawResult).isTrue();
		assertThat(balanceResult).isEqualTo(newBalance);
	}

	@Test
	void initialBalanceAndGreaterWithdrawDontAllowed() {
		Long accountId = 1L;

		BigDecimal balance = BigDecimal.valueOf(500.0);
		BigDecimal withdraw = BigDecimal.valueOf(700.0);
		BigDecimal newBalance = balance;

		Account account = new Account(accountId, balance);

		Boolean withdrawResult = account.withdraw(withdraw);

		BigDecimal balanceResult = account.getFinalBalance();

		assertThat(withdrawResult).isFalse();
		assertThat(balanceResult).isEqualTo(newBalance);
	}

	@Test
	void depositWithInitialBalanceAndGreaterWithdrawDontAllowed() {
		Long accountId = 1L;

		BigDecimal balance = BigDecimal.valueOf(500.0);
		BigDecimal deposit = BigDecimal.valueOf(300.0);
		BigDecimal withdraw = BigDecimal.valueOf(900.0);
		BigDecimal newBalance = balance.add(deposit);

		Account account = new Account(accountId, balance);

		Boolean depositResult = account.deposit(deposit);
		Boolean withdrawResult = account.withdraw(withdraw);

		BigDecimal balanceResult = account.getFinalBalance();

		assertThat(depositResult).isTrue();
		assertThat(withdrawResult).isFalse();
		assertThat(balanceResult).isEqualTo(newBalance);
	}

}