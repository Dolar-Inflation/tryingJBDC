package com.messenger.tryingjbdc.Interfaces;

import com.messenger.tryingjbdc.DTO.AccountDTO;

public interface EventListener {
    void update(String message, AccountDTO account);
}
