package com.messenger.tryingjbdc.Services;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Entityes.Account;
import com.messenger.tryingjbdc.EventManager.EventManager;
import com.messenger.tryingjbdc.Listeners.CreateListener;
import com.messenger.tryingjbdc.Listeners.FindByIdListener;
import com.messenger.tryingjbdc.Listeners.GetAllListener;
import com.messenger.tryingjbdc.Mappers.AccountMapper;
import com.messenger.tryingjbdc.Repositoryies.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;
    public EventManager eventManager;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;


        this.eventManager = new EventManager("found account", "found", "add account");



        eventManager.subscribe("add account", new CreateListener());
        eventManager.subscribe("found account",new FindByIdListener());
        eventManager.subscribe("found",new GetAllListener());
    }


    public AccountDTO getAccountById(Long id) {
       if (id == 10){
           eventManager.unsubscribe("found account 10", FindByIdListener.class);
       }
       else if (id == 7) eventManager.subscribe("found account", new FindByIdListener());
       AccountDTO dto = accountMapper.toDtoList(accountRepository.getAccountById(Math.toIntExact(id)));
        eventManager.notify("found account", dto);
        return dto;
    }
    public List<AccountDTO> getAllAccounts() {
       List<AccountDTO> accountDTOS = accountMapper.toDtoList(accountRepository.getAllAccounts());
       eventManager.notify("found",  accountDTOS);
        return accountDTOS;
    }

    public void createAccount(AccountDTO accountDTO) {
        Account account = accountMapper.toEntity(accountDTO);
         accountRepository.addAccount(account);
         eventManager.notify("add account",accountDTO);

    }

}
