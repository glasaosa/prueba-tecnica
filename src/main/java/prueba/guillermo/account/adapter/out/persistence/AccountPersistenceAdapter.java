package prueba.guillermo.account.adapter.out.persistence;

import java.math.BigDecimal;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import prueba.guillermo.account.application.port.out.CreateAccountPort;
import prueba.guillermo.account.application.port.out.GetAccountPort;
import prueba.guillermo.account.application.port.out.UpdateAccountPort;
import prueba.guillermo.account.domain.Account;
import prueba.guillermo.account.domain.Transaction;

@Component
@AllArgsConstructor
class AccountPersistenceAdapter implements GetAccountPort, CreateAccountPort, UpdateAccountPort {

	private final AccountEntityMapper accountMapper;
	private final AccountRepository accountRepository;

	private final TransactionEntityMapper transactionMapper;
	private final TransactionRepository transactionRepository;

	@Override
	public Account createAccount() {
		final AccountEntity account = accountRepository.save(new AccountEntity());

		return accountMapper.mapToDomain(account, BigDecimal.ZERO);
	}

	@Override
	public Account getAccount(Long accountId) {
		//TODO: EXCEPTION
		final AccountEntity account = accountRepository.findById(accountId).orElseThrow(EntityNotFoundException::new);

		final BigDecimal depositBalance = Optional.ofNullable(transactionRepository.getDepositBalance(account.getId()))
				.map(BigDecimal::valueOf).orElse(BigDecimal.ZERO);
		final BigDecimal withdrawBalance = Optional.ofNullable(transactionRepository.getWithdrawBalance(account.getId()))
				.map(BigDecimal::valueOf).orElse(BigDecimal.ZERO);

		return accountMapper.mapToDomain(account, depositBalance.subtract(withdrawBalance));
	}

	@Override
	public Account updateAccount(Account account) {
		for (Transaction transaction : account.getTransactions()) {
			transactionRepository.save(transactionMapper.mapToEntity(transaction));
		}
		return new Account(account.getId(), account.getFinalBalance());
	}

}
