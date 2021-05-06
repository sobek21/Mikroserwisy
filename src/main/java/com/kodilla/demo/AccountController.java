package com.kodilla.demo;

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


