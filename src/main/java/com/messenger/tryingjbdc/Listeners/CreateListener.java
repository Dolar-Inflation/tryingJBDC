package com.messenger.tryingjbdc.Listeners;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Interfaces.EventListener;

import java.util.List;

public class CreateListener implements EventListener {



    @Override
    public <D> void update(String message, D dto) {
       if (dto instanceof AccountDTO account) {

           System.out.println(message+account);

       }
       else if (dto instanceof List<?> list){
           System.out.println(message+list);
       }
       else throw new ClassCastException();
    }

//    @Override
//    public void update(String message, AccountDTO account) {
//        System.out.println(message+account);
//    }
}
