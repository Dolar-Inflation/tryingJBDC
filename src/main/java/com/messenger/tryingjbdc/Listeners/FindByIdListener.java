package com.messenger.tryingjbdc.Listeners;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Interfaces.EventListener;

public class FindByIdListener implements EventListener {
    @Override
    public void update(String message, AccountDTO account) {
        System.out.println(message + account);
    }
}
