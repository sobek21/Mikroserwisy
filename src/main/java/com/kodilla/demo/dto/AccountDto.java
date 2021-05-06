package com.kodilla.demo.dto;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {

  private long id;
  private String nrb;
  private String currency;
  private BigDecimal availableFunds;
}
