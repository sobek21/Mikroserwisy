package com.kodilla.demo.controller;

import com.kodilla.demo.dto.AccountDto;
import com.kodilla.demo.mapper.AccountMapper;
import com.kodilla.demo.entity.Account;
import com.kodilla.demo.repository.AccountRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AccountRepository accountRepository;

  private final AccountMapper accountMapper;


  @GetMapping("/v1/accounts")
  public AccountDto getAccounts(@RequestParam long ConsumerID) {
    Optional<Account> account = accountRepository.findById(ConsumerID);
    return accountMapper.accountToAccountDto(account.get());
  }
}


