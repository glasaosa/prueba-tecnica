package prueba.guillermo.account.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

@Value
@AllArgsConstructor
public class Transaction {

	private Long id;

	@NonNull
	private final BigDecimal amount;

	@NonNull
	private final LocalDateTime timestamp;

	private final Long sourceAccount;

	private final Long targetAccount;

	public Transaction(@NonNull BigDecimal amount, @NonNull LocalDateTime timestamp, Long sourceAccount,
			Long targetAccount) {
		this.id = null;
		this.amount = amount;
		this.timestamp = timestamp;
		this.sourceAccount = sourceAccount;
		this.targetAccount = targetAccount;
	}

}
