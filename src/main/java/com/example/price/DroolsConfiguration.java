package com.example.price;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfiguration {
    @Bean
    KieContainer kieContainer() {
        return KieServices.Factory.get().getKieClasspathContainer();
    }
}
