package com.infinitelambda.demo.service.impl;

import com.infinitelambda.demo.service.EmployeeService;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class EmployeeServiceImpl implements EmployeeService {

    @PreDestroy
    public void sayGoodBye() {
        System.out.println("Goodbye from Employee Service.");
    }

    @PostConstruct
    public void sayHi() {
        System.out.println("Hi from Employee Service.");
    }
}
