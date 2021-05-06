package com.kodilla.demo;

import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AccountMapper {

  AccountDto accountToAccountDto(Account account);

  List<AccountDto> accountToAccountDtos(List<Account> accounts);

}
