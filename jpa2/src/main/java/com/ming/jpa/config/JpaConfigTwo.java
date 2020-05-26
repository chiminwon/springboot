package com.ming.jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "com.ming.jpa.dao2", entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanTwo", transactionManagerRef = "platformTransactionManagerOne")
public class JpaConfigTwo {

    @Autowired
    @Qualifier(value = "dsTwo")
    DataSource dsTwo;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanTwo(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dsTwo)
                .packages("com.ming.jpa.model")
                .properties(jpaProperties.getProperties())
                .persistenceUnit("pu2")
                .build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerTwo(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean factoryBean = localContainerEntityManagerFactoryBeanTwo(builder);
        return new JpaTransactionManager(factoryBean.getObject());
    }
}
