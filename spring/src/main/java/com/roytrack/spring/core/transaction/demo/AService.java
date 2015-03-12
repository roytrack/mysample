package com.roytrack.spring.core.transaction.demo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by roytrack on 2015/1/30.
 * 是先执行 然后再对事务进行的回滚
 * 00:52:39.369 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager - Creating new transaction with name [com.roytrack.spring.core.transaction.demo.AService.update]: PROPAGATION_REQUIRED,ISOLATION_DEFAULT
 00:52:39.371 [main] DEBUG org.springframework.jdbc.datasource.DriverManagerDataSource - Creating new JDBC DriverManager Connection to [jdbc:mysql://localhost:3306/myblog?zeroDateTimeBehavior=round&useUnicode=true&characterEncoding=UTF-8]
 00:52:39.829 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager - Acquired Connection [com.mysql.jdbc.JDBC4Connection@742ff096] for JDBC transaction
 00:52:39.845 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager - Switching JDBC Connection [com.mysql.jdbc.JDBC4Connection@742ff096] to manual commit
 00:52:39.846 [main] TRACE org.springframework.transaction.support.TransactionSynchronizationManager - Bound value [org.springframework.jdbc.datasource.ConnectionHolder@48075da3] for key [org.springframework.jdbc.datasource.DriverManagerDataSource@8458f04] to thread [main]
 00:52:39.847 [main] TRACE org.springframework.transaction.support.TransactionSynchronizationManager - Initializing transaction synchronization
 00:52:39.849 [main] TRACE org.springframework.transaction.interceptor.TransactionInterceptor - Getting transaction for [com.roytrack.spring.core.transaction.demo.AService.update]
 00:52:39.920 [main] DEBUG org.springframework.jdbc.core.JdbcTemplate - Executing SQL update [update a set  a=1,b=2 where c=3]
 00:52:39.922 [main] TRACE org.springframework.transaction.support.TransactionSynchronizationManager - Retrieved value [org.springframework.jdbc.datasource.ConnectionHolder@48075da3] for key [org.springframework.jdbc.datasource.DriverManagerDataSource@8458f04] bound to thread [main]
 00:52:39.923 [main] TRACE org.springframework.transaction.support.TransactionSynchronizationManager - Retrieved value [org.springframework.jdbc.datasource.ConnectionHolder@48075da3] for key [org.springframework.jdbc.datasource.DriverManagerDataSource@8458f04] bound to thread [main]
 00:52:39.929 [main] DEBUG org.springframework.jdbc.core.JdbcTemplate - SQL update affected 1 rows
 00:52:39.936 [main] TRACE org.springframework.transaction.support.TransactionSynchronizationManager - Retrieved value [org.springframework.jdbc.datasource.ConnectionHolder@48075da3] for key [org.springframework.jdbc.datasource.DriverManagerDataSource@8458f04] bound to thread [main]
 00:52:39.938 [main] TRACE org.springframework.transaction.interceptor.TransactionInterceptor - Completing transaction for [com.roytrack.spring.core.transaction.demo.AService.update] after exception: java.lang.NullPointerException
 00:52:39.938 [main] TRACE org.springframework.transaction.interceptor.RuleBasedTransactionAttribute - Applying rules to determine whether transaction should rollback on java.lang.NullPointerException
 00:52:39.939 [main] TRACE org.springframework.transaction.interceptor.RuleBasedTransactionAttribute - Winning rollback rule is: null
 00:52:39.940 [main] TRACE org.springframework.transaction.interceptor.RuleBasedTransactionAttribute - No relevant rollback rule found: applying default rules
 00:52:39.941 [main] TRACE org.springframework.jdbc.datasource.DataSourceTransactionManager - Triggering beforeCompletion synchronization
 00:52:39.941 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager - Initiating transaction rollback
 00:52:39.942 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager - Rolling back JDBC transaction on Connection [com.mysql.jdbc.JDBC4Connection@742ff096]
 00:52:39.946 [main] TRACE org.springframework.jdbc.datasource.DataSourceTransactionManager - Triggering afterCompletion synchronization
 00:52:39.947 [main] TRACE org.springframework.transaction.support.TransactionSynchronizationManager - Clearing transaction synchronization
 00:52:39.947 [main] TRACE org.springframework.transaction.support.TransactionSynchronizationManager - Removed value [org.springframework.jdbc.datasource.ConnectionHolder@48075da3] for key [org.springframework.jdbc.datasource.DriverManagerDataSource@8458f04] from thread [main]
 00:52:39.950 [main] DEBUG org.springframework.jdbc.datasource.DataSourceTransactionManager - Releasing JDBC Connection [com.mysql.jdbc.JDBC4Connection@742ff096] after transaction
 00:52:39.951 [main] DEBUG org.springframework.jdbc.datasource.DataSourceUtils - Returning JDBC Connection to DataSource
 *
 */
@Getter
@Setter
public class AService {
    ADao aDao;
    public void update(){
        JdbcTemplate template=new JdbcTemplate(aDao.getDataSource());
        template.update("update a set  a=1,b=2 where c=3");
        throw  new NullPointerException();
    }
}
