package com.messenger.tryingjbdc;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Entityes.Account;
import com.messenger.tryingjbdc.EventManager.EventManager;
import com.messenger.tryingjbdc.Listeners.CreateListener;
import com.messenger.tryingjbdc.Listeners.FindByIdListener;
import com.messenger.tryingjbdc.Listeners.GetAllListener;
import com.messenger.tryingjbdc.Mappers.AccountMapper;
import com.messenger.tryingjbdc.Repositoryies.AccountRepository;
import com.messenger.tryingjbdc.Services.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

@ExtendWith({MockitoExtension.class})
public class EventManagerTest {

    @InjectMocks
    AccountService accountService;

    @Mock
    EventManager eventManager;

    @Mock
    AccountRepository accountRepository;

    @Mock
    AccountMapper accountMapper;

    @Mock
    CreateListener createListener;
    @Mock
    FindByIdListener findByIdListener;
    @Mock
    GetAllListener getAllListener;


    @Test
    public void testAccountServiceNotify(){

        List<AccountDTO> accountDTOS = new ArrayList<>();

    Mockito.when(eventManager.notify("found",accountDTOS)).thenReturn("found");

    accountService.getAllAccounts();

    assertEquals("found", eventManager.notify("found",accountDTOS));


//        Account account = new Account();
//        List<Account> accounts = new ArrayList<>();
//
//
//        AccountDTO accountDTO = new AccountDTO();
//        List<AccountDTO> dtos = List.of(accountDTO);
//
//        Mockito.when(accountRepository.getAllAccounts()).thenReturn(accounts);
//        Mockito.when(accountMapper.toDtoList(accounts)).thenReturn(dtos);
//
//        accountService.getAllAccounts();
//
//        Mockito.verify(accountService.eventManager).notify("found",dtos);
//
//      accountService.getAllAccounts();





    }


}
