package com.roytrack.dailytest.commmons_beanutils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created by roytrack on 2016-08-25.
 */
@Getter
@Setter
@ToString
public class Abean {
    private String subject;
    private BigDecimal amount;
    private BBean bBean;

}
