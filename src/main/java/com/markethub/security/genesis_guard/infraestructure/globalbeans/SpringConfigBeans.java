package com.markethub.security.genesis_guard.infraestructure.globalbeans;

import com.markethub.security.genesis_guard.infraestructure.components.CustomResponseErrorHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringConfigBeans {

    public static String urlBaseKernel;

    @Bean
    RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new CustomResponseErrorHandler());
        return restTemplate;
    }

    @Value("${config.base.url.service.core}")
    public void setUriKernel(String urlBaseKernelInyect){
        urlBaseKernel = urlBaseKernelInyect;
    }
}
