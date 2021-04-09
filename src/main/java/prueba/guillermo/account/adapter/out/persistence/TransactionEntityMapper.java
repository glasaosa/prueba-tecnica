package prueba.guillermo.account.adapter.out.persistence;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import prueba.guillermo.account.domain.Transaction;

@Component
class TransactionEntityMapper {

	public Transaction mapToDomain(TransactionEntity transaction) {
		return new Transaction(transaction.getId(), BigDecimal.valueOf(transaction.getAmount()),
				transaction.getTimestamp(), transaction.getSourceAccountId(), transaction.getTargetAccountId());
	}

	public TransactionEntity mapToEntity(Transaction transaction) {
		return new TransactionEntity(transaction.getId(), transaction.getAmount().doubleValue(),
				transaction.getTimestamp(), transaction.getSourceAccount(), transaction.getTargetAccount());
	}

}
