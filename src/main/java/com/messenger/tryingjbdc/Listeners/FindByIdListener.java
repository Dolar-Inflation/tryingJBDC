package com.messenger.tryingjbdc.Listeners;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Interfaces.EventListener;

public class FindByIdListener implements EventListener {
    private AccountDTO accountDTO;
//    @Override
//    public void update(String message, AccountDTO account) {
//        System.out.println(message + account);
//    }

    @Override
    public <D> void update(String message, D dto) {
        if (dto instanceof AccountDTO) {
            accountDTO = (AccountDTO) dto;
            System.out.println(accountDTO +""+ message);
        }
    }
}
