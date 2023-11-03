package com.ganilabstest.MicroSec.test.api.Configurations;

import com.ganilabs.MicroSecCore.MicroSec;
import com.ganilabs.MicroSecCore.annotations.EnableMicroSec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableMicroSec
@ComponentScan(basePackages = "com.ganilabstest.MicroSec.test.api")
public class MicroSecBeanMain {
    @Bean
    public MicroSec getMicro(){
        return new MicroSec();
    }
}
