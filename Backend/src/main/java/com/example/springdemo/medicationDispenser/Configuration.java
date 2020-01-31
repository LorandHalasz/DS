package com.example.springdemo.medicationDispenser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.io.IOException;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private GreeterImplService greeterImpl;

    @Autowired
    public Configuration(GreeterImplService greeterImpl) {
        this.greeterImpl = greeterImpl;
    }

    @Bean
    public void startServer() {

        new Thread(() -> {
            final RPCServer server = new RPCServer(greeterImpl);

            try {
                server.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.blockUntilShutdown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
