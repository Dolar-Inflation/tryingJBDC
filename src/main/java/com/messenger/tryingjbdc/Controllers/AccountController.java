package com.messenger.tryingjbdc.Controllers;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Entityes.Account;
import com.messenger.tryingjbdc.Services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public AccountDTO getAccount(@PathVariable int id) {

        return accountService.getAccountById((long) id);
    }


    @GetMapping("/")
    public List<AccountDTO> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/create")
    public void createAccount(@RequestBody AccountDTO accountDTO) {
        accountService.createAccount(accountDTO);
    }


}
