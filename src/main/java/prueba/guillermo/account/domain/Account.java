package prueba.guillermo.account.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@EqualsAndHashCode
public class Account {

	@Getter
	private final Long id;

	private final BigDecimal balance;

	private final List<Transaction> transactions;

	public Account(@NonNull Long id, BigDecimal balance) {
		this.id = id;
		this.balance = balance != null ? balance : BigDecimal.ZERO;
		this.transactions = new ArrayList<Transaction>();
	}

	public BigDecimal getInitialBalance() {
		return this.balance;
	}

	public BigDecimal getFinalBalance() {
		return transactions.stream().map(t -> id.equals(t.getTargetAccount()) ? t.getAmount() : t.getAmount().negate())
				.reduce(balance, BigDecimal::add);
	}

	public List<Transaction> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}

	public boolean withdraw(BigDecimal amount) {
		if (withdrawAllowed(amount)) {
			transactions.add(new Transaction(amount, LocalDateTime.now(), id, null));

			return true;
		}
		return false;
	}

	public boolean deposit(BigDecimal amount) {
		transactions.add(new Transaction(amount, LocalDateTime.now(), null, id));

		return true;
	}

	private boolean withdrawAllowed(BigDecimal amount) {
		return getFinalBalance().compareTo(amount) >= 0;
	}

}
