package prueba.guillermo.api;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import prueba.guillermo.account.application.port.in.DepositCommand;
import prueba.guillermo.account.application.port.in.DepositUseCase;
import prueba.guillermo.account.application.port.in.WithdrawCommand;
import prueba.guillermo.account.application.port.in.WithdrawUseCase;
import prueba.guillermo.api.dto.TransactionDTO;
import prueba.guillermo.user.application.port.in.InfoCommand;
import prueba.guillermo.user.application.port.in.InfoUseCase;
import prueba.guillermo.user.domain.User;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
class AccountController {

	private final InfoUseCase infoUseCase;
	private final DepositUseCase depositUseCase;
	private final WithdrawUseCase withdrawUseCase;

	@PostMapping(path = "/deposit")
	public ResponseEntity<Boolean> deposit(@Valid @RequestBody TransactionDTO deposit, Authentication authentication) {
		User user = infoUseCase.userInfo(new InfoCommand((String) authentication.getPrincipal()));

		return ResponseEntity.ok(depositUseCase
				.deposit(new DepositCommand(user.getAccountId(), BigDecimal.valueOf(deposit.getAmount()))));
	}

	@PostMapping(path = "/withdraw")
	public ResponseEntity<Boolean> withdraw(@Valid @RequestBody TransactionDTO withdraw, Authentication authentication) {
		User user = infoUseCase.userInfo(new InfoCommand((String) authentication.getPrincipal()));

		return ResponseEntity.ok(withdrawUseCase
				.withdraw(new WithdrawCommand(user.getAccountId(), BigDecimal.valueOf(withdraw.getAmount()))));
	}

}