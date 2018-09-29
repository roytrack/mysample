package com.roytrack.dao.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * CREATE TABLE `log_entity` (
 * `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
 * `sheet_no` varchar(50) NOT NULL COMMENT '单号id',
 * `customer_no` varchar(50) DEFAULT NULL COMMENT '用户id',
 * `amount` decimal(16,2) DEFAULT NULL COMMENT '金额',
 * PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='日志表';
 * <p>
 * <p>
 * Created by roytrack on 2016-09-08.
 */

@Getter
@Setter
@ToString
public class LogEntity {

  private Long id;

  private String sheetNo;

  private String customerNo;

  private BigDecimal amount;


}
