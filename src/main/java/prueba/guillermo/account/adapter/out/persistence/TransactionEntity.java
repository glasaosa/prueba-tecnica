package prueba.guillermo.account.adapter.out.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "transaction")
@AllArgsConstructor
@NoArgsConstructor
class TransactionEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column
	private Double amount;

	@Column
	private LocalDateTime timestamp;

	@Column(name = "source_account_id")
	private Long sourceAccountId;

	@Column(name = "target_account_id")
	private Long targetAccountId;

}
