package com.kodilla.demo.controller;

import com.kodilla.demo.dto.AccountDto;
import com.kodilla.demo.entity.Account;
import com.kodilla.demo.mapper.AccountMapper;
import com.kodilla.demo.repository.AccountRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RefreshScope
@Slf4j
@RestController
@RequestMapping("/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

  private final AccountRepository accountRepository;

  private final AccountMapper accountMapper;

  @Value("${application.allow-get-accounts}")
  private boolean allowGetAccounts;


  @GetMapping
  public AccountDto getAccounts(@RequestParam("customerId") long customerId) {
    if(!allowGetAccounts) {
    log.info("Getting accounts is disabled");
    throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
    }
    Account account = new Account();
    return accountMapper.accountToAccountDto(account);
  }
}


