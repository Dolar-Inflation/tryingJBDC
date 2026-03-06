package com.messenger.tryingjbdc;


import com.messenger.tryingjbdc.Controllers.AccountController;
import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Entityes.Account;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.messenger.tryingjbdc.EventManager.EventManager;
import com.messenger.tryingjbdc.Mappers.AccountMapper;
import com.messenger.tryingjbdc.Repositoryies.AccountRepository;
import com.messenger.tryingjbdc.Services.AccountService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@Transactional
public class AccountServiceTest {

    @InjectMocks
    AccountService accountServiceInjectMock;

@Mock
EventManager eventManager;

    @Mock
    AccountRepository accountRepository;

    @Mock
    AccountMapper accountMapper;


    AccountService accountServiceMock = Mockito.mock(AccountService.class);

    AccountController accountController = new AccountController(accountServiceMock);


    @Test
    public void TestAccountService() {
        AccountDTO accountDTO = new AccountDTO();

        Mockito.when(accountServiceMock.getAllAccounts()).thenReturn(List.of(accountDTO));

        List<AccountDTO> result = accountController.getAllAccounts();

//        assert result.equals(List.of(AccountDTO.class));
        assertEquals(List.of(accountDTO), result);
        assertTrue(result.stream().allMatch(dto -> dto instanceof AccountDTO));

    }
//    @Test
//    public void TestEventManager() {
//       List< AccountDTO> accountDTO = List.of(new AccountDTO());
//       Mockito.when(accountRepository.getAllAccounts()).thenReturn(List.of());
//        Mockito.when(accountMapper.toDto(List.of())).thenReturn(accountDTO);
//        accountServiceInjectMock.getAllAccounts();
//        Mockito.verify(eventManager).notify("found", accountDTO);
//
//
//
//
//    }
}
