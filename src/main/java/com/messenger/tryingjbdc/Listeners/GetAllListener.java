package com.messenger.tryingjbdc.Listeners;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Interfaces.EventListener;

import java.util.ArrayList;
import java.util.List;

public class GetAllListener implements EventListener {
    @Override
    public <D> void update(String message, D dto) {
        if (dto instanceof List<?> acc){
            System.out.println(message+dto.toString());
        }
    }
}
