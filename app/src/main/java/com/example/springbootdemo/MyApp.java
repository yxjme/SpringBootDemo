package com.example.springbootdemo;

import android.app.Application;
import android.content.Context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class MyApp extends Application {

  private static   Context context ;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext() ;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringApplication.class, args);
    }
}
