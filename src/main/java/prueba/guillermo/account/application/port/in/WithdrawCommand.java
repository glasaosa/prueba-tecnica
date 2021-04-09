package prueba.guillermo.account.application.port.in;

import lombok.Value;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

@Value
public class WithdrawCommand {

    @NotNull
    private final Long accountId;

    @NotNull
    private final BigDecimal amount;
    
}
