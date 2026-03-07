package com.messenger.tryingjbdc.Mappers;

import com.messenger.tryingjbdc.DTO.AccountDTO;
import com.messenger.tryingjbdc.Entityes.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

AccountDTO toDtoList(Account account);



List<AccountDTO> toDtoList(List<Account> accounts);


@Mapping(target = "id", ignore = true)
Account toEntity(AccountDTO accountDTO);

}
