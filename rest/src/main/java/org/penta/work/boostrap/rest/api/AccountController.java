package org.penta.work.boostrap.rest.api;

import org.penta.work.boostrap.port.RequestAccounts;
import org.penta.work.boostrap.port.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private RequestAccounts requestAccounts;

    public AccountController(RequestAccounts requestAccounts) {
        this.requestAccounts = requestAccounts;
    }

    @GetMapping(value = "/active")
    ResponseEntity activeAccounts() {
        List<Account> accounts = requestAccounts.getActiveAccounts();
        return new ResponseEntity<>(accounts,
                HttpStatus.OK);
    }


    @GetMapping(value = "/add")
    ResponseEntity add() {
        Account account = Account.builder().name("Shakti").accountNo(500).accountBalance(BigDecimal.valueOf(111L)).build();
        boolean result = requestAccounts.addAccount(account);
        return new ResponseEntity<>(result,
                HttpStatus.OK);
    }

}
