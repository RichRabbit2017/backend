package com.mindgray.cleanwheels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
public class App extends SpringBootServletInitializer
{
    //    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {

        return builder.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
