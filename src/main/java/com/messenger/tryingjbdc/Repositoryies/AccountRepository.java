package com.messenger.tryingjbdc.Repositoryies;

import com.messenger.tryingjbdc.Entityes.Account;
import com.messenger.tryingjbdc.Mappers.AccountRawMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepository {

   private final JdbcTemplate jdbcTemplate;

    public AccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Account> getAllAccounts() {
        return jdbcTemplate.query("SELECT id, name, password FROM account",new AccountRawMapper());
    }

    public Account getAccountById(int id) {
        return jdbcTemplate.queryForObject("SELECT id,name,password FROM account WHERE id=?",new AccountRawMapper(),id);
    }

    public int addAccount(Account account) {
        return jdbcTemplate.update("INSERT INTO account(name,password) VALUES(?,?)",account.getName(),account.getPassword());

    }

}
