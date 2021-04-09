package prueba.guillermo.account.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

	@Query("select sum(t.amount) from TransactionEntity t " +
				"where t.targetAccountId = :accountId")
	Double getDepositBalance(@Param("accountId") Long accountId);

	@Query("select sum(t.amount) from TransactionEntity t " +
				"where t.sourceAccountId = :accountId")
	Double getWithdrawBalance(@Param("accountId") Long accountId);

}
