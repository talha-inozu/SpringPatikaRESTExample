package com.example.springpatika.tutorials.bean;

import com.example.springpatika.tutorials.beandto.BeanDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfig {
    @Bean(initMethod = "initialBeanMethod",destroyMethod = "destroyBeanMethod")
    @Scope("singleton")
    public BeanDto beanDto(){

        return BeanDto.builder().beandId(0L).beanName("bean").beadData("beanData").build();
    }

}
