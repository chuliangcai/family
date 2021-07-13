package com.family.dubbo.provider;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDubbo
public class ProviderConfiguration {

    @Bean
    public ApplicationConfig applicationConfig() {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("dubbo-demo-application-server");
        return applicationConfig;
    }

   @Bean
    public RegistryConfig registryConfig() {
       RegistryConfig registryConfig = new RegistryConfig();
       registryConfig.setAddress("zookeeper://192.168.56.102:2181");
       return registryConfig;
   }

}
