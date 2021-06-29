package com.exam.gradle.app.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.springframework.context.annotation.Configuration;

import com.exam.gradle.app.rest.ProductRestImpl;

@Configuration
@ApplicationPath("/api")
public class AppConfig extends Application {
    @Override
    public Set<Object> getSingletons() {
    	Set<Object> singletons = new HashSet<>();
        singletons.add(new ProductRestImpl());
        return singletons;
    }
}
