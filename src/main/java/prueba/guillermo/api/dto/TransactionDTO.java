package prueba.guillermo.api.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;

@Data
public class TransactionDTO {

	@NotNull
	@Positive
	private Double amount;
	
}
