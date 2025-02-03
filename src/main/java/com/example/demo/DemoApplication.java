package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:8080";

        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // Windows
            Runtime.getRuntime().exec("cmd /c start " + url);
        } else if (os.contains("mac")) {
            // macOS
            Runtime.getRuntime().exec("open " + url);
        } else if (os.contains("nix") || os.contains("nux")) {
            // Linux
            Runtime.getRuntime().exec("xdg-open " + url);
        }
    }
}