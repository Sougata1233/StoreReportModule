package com.sls.report;


/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreReportApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreReportApplication.class, args);
	}
}
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class StoreReportApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StoreReportApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(StoreReportApplication.class, args);
    }

}
