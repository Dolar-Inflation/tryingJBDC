package com.messenger.tryingjbdc.Repositoryies;

import com.messenger.tryingjbdc.Entityes.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends CrudRepository<Account, Long> {
}
