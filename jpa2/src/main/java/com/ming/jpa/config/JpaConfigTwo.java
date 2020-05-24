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
@EnableJpaRepositories(basePackages = "com.ming.jpa.dao", entityManagerFactoryRef = "localContainerEntityManagerFactoryBeanOne")
public class JpaConfigOne {

    @Autowired
    @Qualifier(value = "dsOne")
    DataSource dsOne;

    @Autowired
    JpaProperties jpaProperties;

    @Bean
    @Primary
    LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanOne(EntityManagerFactoryBuilder builder){
        return builder.dataSource(dsOne)
                .packages("com.ming.jpa.model")
                .properties(jpaProperties.getProperties())
                .persistenceUnit("pu1")
                .build();
    }

    @Bean
    PlatformTransactionManager platformTransactionManagerOne(EntityManagerFactoryBuilder builder){
        LocalContainerEntityManagerFactoryBean factoryBean = localContainerEntityManagerFactoryBeanOne(builder);
        return new JpaTransactionManager(factoryBean.getObject());
    }
}
