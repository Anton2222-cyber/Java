package org.example.dz;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({"org.example.dz"})
@EnableAspectJAutoProxy
public class AppConfig {
    public AppConfig() {
    }
}