package az.charming.teachermanagement.configuration;

import az.charming.teachermanagement.service.CoxLazimliClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate getRestTeRestTemplatemplate(){
        return new RestTemplate();
    }

    @Bean
    public CoxLazimliClass getCoxLazimliClass(){
        return new CoxLazimliClass();
    }

}
