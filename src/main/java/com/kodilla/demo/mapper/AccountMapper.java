package com.kodilla.demo.mapper;

import com.kodilla.demo.dto.AccountDto;
import com.kodilla.demo.entity.Account;
import java.util.List;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AccountMapper {

  AccountDto accountToAccountDto(Account account);

  List<AccountDto> accountToAccountDtos(List<Account> accounts);

}
