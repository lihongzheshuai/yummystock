package com.coderli.yummystock.web.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Java Config for Spring Context
 *
 * @author li.hzh
 * @date 2016-11-26 15:43
 */
@Configuration
@EnableWebMvc
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.codeli.yummystock")
@Import(EmbeddedServletContainerAutoConfiguration.class)
public class ApplicationContextConfig {
    
    
}
