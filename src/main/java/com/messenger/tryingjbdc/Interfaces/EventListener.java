package com.messenger.tryingjbdc.Interfaces;

import com.messenger.tryingjbdc.DTO.AccountDTO;

public interface EventListener {
    <D> void update(String message, D dto);
}
